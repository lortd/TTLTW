<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Products - Dashboard</title>

  <!-- Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Bootstrap Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

  <link href="${pageContext.request.contextPath}/css/admin/dashboard.css" rel="stylesheet" type="text/css" >
</head>

<body>
  <div class="app">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="brand">
        <div class="brand-badge">CO</div>
        <div>
          <div style="font-weight:900; font-size:18px;">Spodut</div>
          <div style="font-size:12px; color:#6b7280;">Admin Panel</div>
        </div>
      </div>

      <div class="nav-section-title">Menu</div>

      <a class="nav-item" href="#">
        <i class="bi bi-grid-3x3-gap"></i>
        <span>Dashboard</span>
      </a>

      <a class="nav-item active" href="#">
        <i class="bi bi-bag"></i>
        <span>Products</span>
      </a>

      <a class="nav-item ms-3" href="#" style="margin-top:-2px;">
        <i class="bi bi-list-check"></i>
        <span>Product List</span>
      </a>

      <a class="nav-item ms-3" href="#" style="margin-top:-2px;">
        <i class="bi bi-tag"></i>
        <span>Categories</span>
      </a>

      <div class="nav-section-title mt-2">Others</div>

      <a class="nav-item" href="#">
        <i class="bi bi-receipt"></i>
        <span>Sales</span>
      </a>

      <a class="nav-item" href="#">
        <i class="bi bi-people"></i>
        <span>Customers</span>
      </a>

      <a class="nav-item" href="#">
        <i class="bi bi-graph-up"></i>
        <span>Analytics</span>
      </a>

      <a class="nav-item" href="#">
        <i class="bi bi-bell"></i>
        <span>Notifications</span>
      </a>

      <a class="nav-item" href="#">
        <i class="bi bi-gear"></i>
        <span>Settings</span>
      </a>
    </aside>

    <!-- Main -->
    <main class="main">
      <!-- Page header -->
      <div class="page-header">
        <h1 class="page-title">Products</h1>

        <!-- optional right icons -->
        <div class="d-flex align-items-center gap-3">
          <button class="btn btn-outline-secondary btn-sm rounded-circle" type="button" aria-label="Search">
            <i class="bi bi-search"></i>
          </button>
          <button class="btn btn-outline-secondary btn-sm rounded-circle" type="button" aria-label="User">
            <i class="bi bi-person"></i>
          </button>
        </div>
      </div>

      <!-- Panel -->
      <section class="panel">
        <div class="panel-head">
          <h5>Products list</h5>
          <div class="d-flex align-items-center gap-2">
            <button class="btn btn-soft" type="button">
              <i class="bi bi-funnel me-1"></i> Filter
            </button>
            <button class="btn btn-soft" type="button">See All</button>
            <button class="btn btn-primary-soft" type="button">
              <i class="bi bi-plus-lg me-1"></i> Add Product
            </button>
          </div>
        </div>

        <div class="table-wrap">
          <div class="table-responsive">
            <table class="table align-middle mb-0">
              <thead>
                <tr>
                  <th style="width:44px;">
                    <input class="form-check-input" type="checkbox" aria-label="Select all">
                  </th>
                  <th style="min-width:220px;">
                    Product Name <i class="bi bi-caret-down ms-1 text-muted"></i>
                  </th>
                  <th style="min-width:220px;">
                    Category <i class="bi bi-caret-down ms-1 text-muted"></i>
                  </th>
                  <th style="min-width:140px;">
                    Price <i class="bi bi-caret-down ms-1 text-muted"></i>
                  </th>
                  <th style="min-width:120px;">
                    Stock <i class="bi bi-caret-down ms-1 text-muted"></i>
                  </th>
                  <th style="min-width:160px;">
                    Status <i class="bi bi-caret-down ms-1 text-muted"></i>
                  </th>
                  <th class="text-end" style="min-width:120px;">Actions</th>
                </tr>
              </thead>

              <tbody>
                <!-- Row 1 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 1">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/tshirt1/120/120">
                      </div>
                      <span>T-Shirt</span>
                    </div>
                  </td>
                  <td>Women Cloths</td>
                  <td>$79.80</td>
                  <td>79</td>
                  <td>
                    <span class="badge badge-pill badge-scheduled">Scheduled</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 2 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 2">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/shirt2/120/120">
                      </div>
                      <span>Shirt</span>
                    </div>
                  </td>
                  <td>Man Cloths</td>
                  <td>$76.89</td>
                  <td>86</td>
                  <td>
                    <span class="badge badge-pill badge-active">Active</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 3 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 3">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/pant3/120/120">
                      </div>
                      <span>Pant</span>
                    </div>
                  </td>
                  <td>Kid Cloths</td>
                  <td>$86.65</td>
                  <td>74</td>
                  <td>
                    <span class="badge badge-pill badge-draft">Draft</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 4 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 4">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/sweater4/120/120">
                      </div>
                      <span>Sweater</span>
                    </div>
                  </td>
                  <td>Man Cloths</td>
                  <td>$56.07</td>
                  <td>69</td>
                  <td>
                    <span class="badge badge-pill badge-active">Active</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 5 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 5">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/sweater5/120/120">
                      </div>
                      <span>Sweater</span>
                    </div>
                  </td>
                  <td>Man Cloths</td>
                  <td>$56.07</td>
                  <td>69</td>
                  <td>
                    <span class="badge badge-pill badge-scheduled">Scheduled</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 6 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 6">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/jacket6/120/120">
                      </div>
                      <span>Light Jacket</span>
                    </div>
                  </td>
                  <td>Women Cloths</td>
                  <td>$36.00</td>
                  <td>65</td>
                  <td>
                    <span class="badge badge-pill badge-draft">Draft</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 7 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 7">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/half7/120/120">
                      </div>
                      <span>Half Shirt</span>
                    </div>
                  </td>
                  <td>Man Cloths</td>
                  <td>$46.78</td>
                  <td>58</td>
                  <td>
                    <span class="badge badge-pill badge-active">Active</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 8 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 8">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/half8/120/120">
                      </div>
                      <span>Half Shirt</span>
                    </div>
                  </td>
                  <td>Sweater</td>
                  <td>$46.78</td>
                  <td>58</td>
                  <td>
                    <span class="badge badge-pill badge-active">Active</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 9 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 9">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/half9/120/120">
                      </div>
                      <span>Half Shirt</span>
                    </div>
                  </td>
                  <td>Man Cloths</td>
                  <td>$46.78</td>
                  <td>58</td>
                  <td>
                    <span class="badge badge-pill badge-scheduled">Scheduled</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>

                <!-- Row 10 -->
                <tr>
                  <td>
                    <input class="form-check-input" type="checkbox" aria-label="Select row 10">
                  </td>
                  <td>
                    <div class="product-cell">
                      <div class="thumb">
                        <img alt="thumb" src="https://picsum.photos/seed/half10/120/120">
                      </div>
                      <span>Half Shirt</span>
                    </div>
                  </td>
                  <td>Kid</td>
                  <td>$46.78</td>
                  <td>58</td>
                  <td>
                    <span class="badge badge-pill badge-active">Active</span>
                  </td>
                  <td class="text-end">
                    <a href="#" class="text-decoration-none text-primary fw-bold">Det</a>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

        <!-- Pagination (mÃ´ phá»ng) -->
        <div class="panel-foot">
          <button class="btn btn-outline-secondary rounded-pill px-4 py-2" type="button">
            <i class="bi bi-arrow-left me-2"></i> Previous
          </button>

          <div class="page-numbers" aria-label="Pagination">
            <span class="dot active">1</span>
            <span class="dot">2</span>
            <span class="dot">3</span>
            <span class="px-2">...</span>
            <span class="dot">8</span>
            <span class="dot">9</span>
            <span class="dot">10</span>
          </div>

          <div style="width:200px;"></div>
        </div>
      </section>
    </main>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>