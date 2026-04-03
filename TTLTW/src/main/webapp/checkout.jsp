<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Thanh Toán - Web Thuốc Bảo Vệ Thực Vật</title>
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

	<div class="container-fluid page-header py-5">
		<h1 class="text-center text-white display-6 wow fadeInUp"
			data-wow-delay="0.1s">Checkout</h1>
		<ol class="breadcrumb justify-content-center mb-0 wow fadeInUp"
			data-wow-delay="0.3s">
			<li class="breadcrumb-item"><a href="home">Home</a></li>
			<li class="breadcrumb-item active text-white">Checkout</li>
		</ol>
	</div>

	<div class="container-fluid bg-light overflow-hidden py-5">
		<div class="container py-5">
			<h1 class="mb-4 wow fadeInUp" data-wow-delay="0.1s">Billing
				details</h1>

			<form action="place-order" method="POST">
				<div class="row g-5">
					<div class="col-md-12 col-lg-6 col-xl-6 wow fadeInUp"
						data-wow-delay="0.1s">
						<div class="form-item">
							<label class="form-label my-3">Họ và Tên<sup>*</sup></label> <input
								type="text" name="fullname" class="form-control"
								value="${sessionScope.acc.username}" required>
						</div>
						<div class="form-item">
							<label class="form-label my-3">Địa chỉ nhận hàng<sup>*</sup></label>
							<input type="text" name="address" class="form-control"
								value="${sessionScope.acc.address}"
								placeholder="Số nhà, tên đường, tỉnh/thành..." required>
						</div>
						<div class="form-item">
							<label class="form-label my-3">Số điện thoại<sup>*</sup></label>
							<input type="tel" name="phone" class="form-control"
								value="${sessionScope.acc.phone}" required>
						</div>
						<div class="form-item">
							<label class="form-label my-3">Email Address<sup>*</sup></label>
							<input type="email" name="email" class="form-control"
								value="${sessionScope.acc.email}" required>
						</div>

						<div class="form-item mt-3">
							<label class="form-label my-3">Ghi chú đơn hàng</label>
							<textarea name="notes" class="form-control" spellcheck="false"
								cols="30" rows="8"
								placeholder="Ghi chú về thời gian giao hàng hoặc chỉ dẫn địa chỉ..."></textarea>
						</div>
					</div>

					<div class="col-md-12 col-lg-6 col-xl-6 wow fadeInUp"
						data-wow-delay="0.3s">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr class="text-center">
										<th scope="col" class="text-start">Sản phẩm</th>
										<th scope="col">Giá</th>
										<th scope="col">Số lượng</th>
										<th scope="col">Tổng</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="grandTotal" value="0" />
									<c:forEach items="${checkoutList}" var="item">
										<c:set var="grandTotal"
											value="${grandTotal + item.totalPrice}" />
										<tr class="text-center">
											<th scope="row" class="text-start py-4 font-weight-normal">
												${item.productName}</th>
											<td class="py-4"><fmt:formatNumber
													value="${item.unitPrice}" type="currency"
													currencySymbol="$" /></td>
											<td class="py-4">${item.quantity}</td>
											<td class="py-4"><fmt:formatNumber
													value="${item.totalPrice}" type="currency"
													currencySymbol="$" /></td>
										</tr>
									</c:forEach>

									<tr>
										<th scope="row"></th>
										<td class="py-4"></td>
										<td class="py-4 text-end"><p class="mb-0 text-dark py-2">Tạm
												tính</p></td>
										<td class="py-4">
											<div class="py-2 text-center border-bottom border-top">
												<p class="mb-0 text-dark" id="sub-total"
													data-subtotal="${grandTotal}">
													<fmt:formatNumber value="${grandTotal}" type="currency"
														currencySymbol="$" />
												</p>
											</div>
										</td>
									</tr>
									<tr>
										<th scope="row"></th>
										<td class="py-4"><p class="mb-0 text-dark py-4">Vận
												chuyển</p></td>
										<td colspan="2" class="py-4">
											<div class="form-check text-start mb-2">
												<input type="radio" name="shipping"
													class="form-check-input bg-primary border-0 shipping-option"
													id="Shipping-1" value="0" data-shipping="0" checked>
												<label class="form-check-label" for="Shipping-1">Miễn
													phí giao hàng</label>
											</div>

											<div class="form-check text-start">
												<input type="radio" name="shipping"
													class="form-check-input bg-primary border-0 shipping-option"
													id="Shipping-2" value="15" data-shipping="15"> <label
													class="form-check-label" for="Shipping-2">Giao hàng
													nhanh: $15.00</label>
											</div>
										</td>
									</tr>
									<tr>
										<th scope="row"></th>
										<td class="py-4"><p
												class="mb-0 text-dark text-uppercase py-2 fw-bold">TỔNG
												CỘNG</p></td>
										<td class="py-4"></td>
										<td class="py-4">
											<div class="py-2 text-center border-bottom border-top">
												<p class="mb-0 text-dark fw-bold" id="final-total">
													<fmt:formatNumber value="${grandTotal}" type="currency"
														currencySymbol="$" />
												</p>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="row g-0 border-bottom py-3">
							<div class="col-12">
								<div class="form-check text-start my-2">
									<input type="radio" name="paymentMethod"
										class="form-check-input bg-primary border-0" id="Payment-1"
										value="COD" checked> <label class="form-check-label"
										for="Payment-1">Thanh toán khi nhận hàng (COD)</label>
								</div>
							</div>
						</div>
						<div class="row g-0 border-bottom py-3">
							<div class="col-12">
								<div class="form-check text-start my-2">
									<input type="radio" name="paymentMethod"
										class="form-check-input bg-primary border-0" id="Payment-2"
										value="Bank"> <label class="form-check-label"
										for="Payment-2">Chuyển khoản ngân hàng</label>
								</div>
							</div>
						</div>

						<div
							class="row g-4 text-center align-items-center justify-content-center pt-4">
							<button type="submit"
								class="btn btn-primary border-secondary py-3 px-4 text-uppercase w-100 text-white">Xác
								nhận đặt hàng</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>


	<a href="#" class="btn btn-primary btn-lg-square back-to-top"><i
		class="fa fa-arrow-up"></i></a>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
	<script>
document.addEventListener('DOMContentLoaded', function() {
    // 1. Lấy ra số tiền hàng gốc từ thuộc tính data-subtotal
    const subTotalElement = document.getElementById('sub-total');
    const finalTotalElement = document.getElementById('final-total');
    
    if (!subTotalElement || !finalTotalElement) return;
    
    const subTotal = parseFloat(subTotalElement.getAttribute('data-subtotal'));

    // 2. Lấy tất cả các radio button có class shipping-option
    const shippingOptions = document.querySelectorAll('.shipping-option');

    shippingOptions.forEach(option => {
        option.addEventListener('change', function() {
            // Lấy giá trị tiền ship độc lập được khai báo trong data-shipping
            const shippingCost = parseFloat(this.getAttribute('data-shipping'));
            
            // Tính tổng mới
            const newTotal = subTotal + shippingCost;
            
            // Cập nhật lại hiển thị số tiền (Định dạng thủ công theo chuẩn $)
            finalTotalElement.innerText = '$' + newTotal.toFixed(2);
        });
    });
});
</script>
</body>

</html>