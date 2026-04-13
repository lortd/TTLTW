package me.nhom65.util;

import java.util.regex.Pattern;

import me.nhom65.model.User;

public class UserValidcator {

	public static ResultValidcator checkRegister(User inputcheck,String username, String password, String confirmPassword, String gmail, String phone,
			String address) {
		if (username == null || password == null || confirmPassword == null || gmail == null || phone == null || address == null) {
			return ResultValidcator.fail("Không được phép để trống bất kỳ thông tin nào");
		}
		if (username.length() < 3) {
			return ResultValidcator.fail("Tên đăng nhập phải có ít nhất 3 ký tự.");
		}
		if (password.length() < 6) {
			return ResultValidcator.fail("Mật khẩu phải có ít nhất 6 ký tự.");
		}
		if (!password.equals(confirmPassword)) {
			return ResultValidcator.fail("Mật khẩu xác nhận không khớp.");
		}
		if (!isPhone(phone)) {
			return ResultValidcator.fail("Số điện thoại không phù hợp với dạng Việt Nam.");
		}

		if (inputcheck != null && inputcheck.getUserName().equals(username)) {
			return ResultValidcator.fail("Tên đăng nhập đã tồn tại.");
		}
		return ResultValidcator.success();
	}
	
	
	
	public static boolean isPhone(String input) {
		String nPhoneRegex = "(\\+84|0)(3[2-9]|5[2689]|7[06-9]|8[1-9]|9[0-9])([0-9]{7})\\b";
        Pattern nPhonePattern = Pattern.compile(nPhoneRegex);
        return nPhonePattern.matcher(input).find();
	}



	public static class ResultValidcator {
		
		private final boolean success;
		private final String message;
		
		private ResultValidcator(boolean success, String message) {
			this.success = success;
			this.message = message;
		}
		
		public static ResultValidcator success() {
			return new ResultValidcator(true, null);
		}

		public static ResultValidcator fail(String message) {
			return new ResultValidcator(false, message);
		}

		
		public boolean isSuccess() {
			return success;
		}
		public String getMessage() {
			return message;
		}
		
		
	}
	
}
