/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.CartItemDTO;
import entity.User;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trinh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    public User login(String username, String password_hash) {
    	String query = "SELECT * FROM users WHERE username = ? AND password_hash = ?";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password_hash);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                // 2. Map đúng các cột từ bảng users vào constructor của Class
                // Lưu ý: Thứ tự và kiểu dữ liệu phải khớp với class User/Account của bạn
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password_hash"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getInt("role_id"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để dễ debug
        } finally {
            // Nên đóng connection tại đây nếu không dùng connection pool
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from account\n"
                + "where [user] = ?\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String user, String pass) {
        String query = "insert into account\n"
                + "values(?,?,0,0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String pid) {
        String query = "delete from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String name, String image, String price,
            String title, String description, String category, int sid) {
        String query = "INSERT [dbo].[product] \n"
                + "([name], [image], [price], [title], [description], [cateID], [sell_ID])\n"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price,
            String title, String description, String category, String pid) {
        String query = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }


    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("category_id"),
                    rs.getString("image_url"),
                    rs.getBigDecimal("price"),
                    rs.getInt("quantity"),
                    rs.getString("status"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<CartItemDTO> getCartItemsByUserId(int userId) {
        List<CartItemDTO> list = new ArrayList<>();
        String query = "SELECT ci.cart_item_id, p.name AS product_name, p.image_url, " +
                       "ci.quantity, p.price, (ci.quantity * p.price) AS total_price " +
                       "FROM cart_items ci " +
                       "JOIN carts c ON ci.cart_id = c.cart_id " +
                       "JOIN products p ON ci.product_id = p.product_id " +
                       "WHERE c.user_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartItemDTO item = new CartItemDTO();
                item.setCartItemId(rs.getInt("cart_item_id"));
                item.setProductName(rs.getString("product_name"));
                item.setImageUrl(rs.getString("image_url"));
                item.setQuantity(rs.getInt("quantity"));
                item.setUnitPrice(rs.getBigDecimal("price"));
                item.setTotalPrice(rs.getBigDecimal("total_price"));
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void addToCart(int userId, int productId, int quantity) {
        try {
            conn = new DBContext().getConnection();

            String findCartQuery = "SELECT cart_id FROM carts WHERE user_id = ?";
            ps = conn.prepareStatement(findCartQuery);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            int cartId = -1;
            if (rs.next()) {
                cartId = rs.getInt("cart_id");
            } else {
                String insertCart = "INSERT INTO carts (user_id) VALUES (?)";
                ps = conn.prepareStatement(insertCart, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.executeUpdate();
                
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cartId = generatedKeys.getInt(1);
                }
            }

            if (cartId != -1) {
                String checkItem = "SELECT quantity FROM cart_items WHERE cart_id = ? AND product_id = ?";
                ps = conn.prepareStatement(checkItem);
                ps.setInt(1, cartId);
                ps.setInt(2, productId);
                rs = ps.executeQuery();

                if (rs.next()) {
                    String updateQty = "UPDATE cart_items SET quantity = quantity + ? WHERE cart_id = ? AND product_id = ?";
                    ps = conn.prepareStatement(updateQty);
                    ps.setInt(1, quantity);
                    ps.setInt(2, cartId);
                    ps.setInt(3, productId);
                    ps.executeUpdate();
                } else {
                    String insertItem = "INSERT INTO cart_items (cart_id, product_id, quantity) VALUES (?, ?, ?)";
                    ps = conn.prepareStatement(insertItem);
                    ps.setInt(1, cartId);
                    ps.setInt(2, productId);
                    ps.setInt(3, quantity);
                    ps.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    public void updateCartItemQuantity(int cartItemId, String action) {
        String query = "";
        if (action.equals("plus")) {
            query = "UPDATE cart_items SET quantity = quantity + 1 WHERE cart_item_id = ?";
        } else {
            query = "UPDATE cart_items SET quantity = GREATEST(quantity - 1, 1) WHERE cart_item_id = ?";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cartItemId);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void deleteCartItem(int cartItemId) {
        String query = "DELETE FROM cart_items WHERE cart_item_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cartItemId);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    public void updateQuantityDirectly(int cartItemId, int newQty) {
        String query = "UPDATE cart_items SET quantity = ? WHERE cart_item_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, newQty);
            ps.setInt(2, cartItemId);
            ps.executeUpdate();
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> list = dao.getAllProducts();

            System.out.println("ttt");
            int i = 1;
        for (Product o : list) {
            System.out.println(i+": "+o);i++;
        }
    }

}
