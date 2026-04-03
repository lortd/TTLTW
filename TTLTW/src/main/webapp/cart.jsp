<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Electro - Cart</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;600;700&family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div id="spinner"
		class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-border text-primary"
			style="width: 3rem; height: 3rem;" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>

	<jsp:include page="Topbar.jsp"></jsp:include>
	<jsp:include page="Navbar & Hero.jsp"></jsp:include>


	<!-- Single Page Header start -->
	<div class="container-fluid page-header py-5">
		<h1 class="text-center text-white display-6 wow fadeInUp"
			data-wow-delay="0.1s">Cart Page</h1>
		<ol class="breadcrumb justify-content-center mb-0 wow fadeInUp"
			data-wow-delay="0.3s">
			<li class="breadcrumb-item"><a href="#">Home</a></li>
			<li class="breadcrumb-item"><a href="#">Pages</a></li>
			<li class="breadcrumb-item active text-white">Cart Page</li>
		</ol>
	</div>
	<!-- Single Page Header End -->

	<div class="container-fluid py-5">
		<div class="container py-5">
			<form action="checkout" method="POST" id="cartForm">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Sản phẩm</th>
							<th scope="col">Giá</th>
							<th scope="col">Số lượng</th>
							<th scope="col">Tổng</th>
							<th scope="col">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartList}" var="item">
							<tr id="row-${item.cartItemId}">
								<td>${item.productName}</td>
								<td>
									<p class="mb-0 py-4 unit-price" data-price="${item.unitPrice}">
										$${item.unitPrice}</p>
								</td>
								<td>
									<div class="input-group  py-4" style="width: 100px;">
										<div class="input-group-btn">
											<button type="button"
												class="btn btn-sm btn-minus rounded-circle bg-light border"
												onclick="updateQty(this, -1, ${item.cartItemId})">
												<i class="fa fa-minus"></i>
											</button>
										</div>
										<input type="text" name="qty_${item.cartItemId}"
											class="form-control form-control-sm text-center border-0 qty-input"
											value="${item.quantity}" readonly>
										<div class="input-group-btn">
											<button type="button"
												class="btn btn-sm btn-plus rounded-circle bg-light border"
												onclick="updateQty(this, 1, ${item.cartItemId})">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</td>
								<td>
									<p class="mb-0 py-4 item-total-display">$${item.totalPrice}</p>
								</td>
								<td>
									<button type="button"
										onclick="confirmRemove(this, ${item.cartItemId})"
										class="btn btn-md rounded-circle bg-light border">
										<i class="fa fa-times text-danger"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="text-end">
					<h5 class="mb-3">
						Tổng cộng: <span id="grand-total">$0.00</span>
					</h5>
					<button type="submit"
						class="btn btn-primary rounded-pill px-4 py-3 text-uppercase">Tiến
						hành thanh toán</button>
				</div>
			</form>
		</div>
	</div>

	<!-- Back to Top -->
	<a href="#" class="btn btn-primary btn-lg-square back-to-top"><i
		class="fa fa-arrow-up"></i></a>


	<!-- JavaScript Libraries -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>


	<!-- Template Javascript -->
	<script src="js/main.js"></script>
	<script>
function updateQty(btn, delta, cartItemId) {
    const row = btn.closest('tr');
    const input = row.querySelector('.qty-input');
    const unitPrice = parseFloat(row.querySelector('.unit-price').dataset.price);
    const itemTotalDisplay = row.querySelector('.item-total-display');
    
    let currentQty = parseInt(input.value);
    let newQty = currentQty + delta;

    // Nếu số lượng mới là 0, gọi hàm xóa
    if (newQty <= 0) {
        confirmRemove(btn, cartItemId);
        return;
    }

    // Cập nhật số lượng vào ô input (tăng/giảm đúng 1 đơn vị)
    input.value = newQty;

    // Tính toán lại giá của dòng này: Giá gốc * Số lượng mới
    const newPrice = unitPrice * newQty;
    itemTotalDisplay.innerText = '$' + newPrice.toFixed(2);

    // Tính lại tổng hóa đơn cuối trang
    calculateGrandTotal();
}

function confirmRemove(btn, cartItemId) {
    if (confirm("Bạn có muốn xóa sản phẩm này khỏi giỏ hàng?")) {
        // Xóa dòng trên giao diện
        btn.closest('tr').remove();
        
        // Gọi AJAX xóa trong Database ngay lập tức để đồng bộ
        $.ajax({
            url: 'remove-from-cart',
            type: 'GET',
            data: { id: cartItemId },
            success: function() {
                calculateGrandTotal();
            }
        });
    }
}

function calculateGrandTotal() {
    let total = 0;
    document.querySelectorAll('.item-total-display').forEach(p => {
        total += parseFloat(p.innerText.replace('$', ''));
    });
    document.getElementById('grand-total').innerText = '$' + total.toFixed(2);
}

// Chạy tính tổng khi vừa load trang
document.addEventListener('DOMContentLoaded', calculateGrandTotal);
</script>
</body>
</html>