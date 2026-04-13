<!doctype html>
<html lang="vi">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Dashboard</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

  <style>
    :root{ --sidebar-w: 270px; }
    body{ background:#f4f5f7; color:#1f2937; }

    .app{ min-height: 100vh; display:flex; }
    .sidebar{
      width: var(--sidebar-w);
      background:#fff;
      border-right:1px solid #e5e7eb;
      position: sticky; top:0;
      height: 100vh;
      overflow:auto;
    }
    .brand{
      padding: 18px 18px 10px;
      display:flex; align-items:center; gap:12px;
    }
    .brand-badge{
      width:36px;height:36px;border-radius:10px;
      background:#4f46e5;color:#fff;
      display:flex; align-items:center; justify-content:center;
      font-weight:800; letter-spacing:.5px;
    }
    .nav-section-title{
      font-size:12px; color:#6b7280;
      padding: 10px 18px 6px;
    }
    .nav-item{
      display:flex; align-items:center; gap:12px;
      padding: 10px 18px;
      margin: 2px 10px;
      border-radius:12px;
      color:#374151;
      text-decoration:none;
      font-weight: 600;
    }
    .nav-item:hover{ background:#f3f4f6; color:#111827; }
    .nav-item.active{ background:#eef2ff; color:#4f46e5; border:1px solid #e0e7ff; }

    .main{ flex:1; padding: 22px 22px 30px; }
    .page-header{
      display:flex; align-items:center; justify-content:space-between; gap:16px;
      margin-bottom: 14px;
    }
    .page-title{ font-size: 26px; font-weight: 900; margin:0; }

    .panel{
      background:#fff;
      border:1px solid #e5e7eb;
      border-radius: 14px;
      box-shadow: 0 1px 0 rgba(0,0,0,.02);
    }
    .panel-head{
      padding: 16px 18px;
      display:flex; align-items:center; justify-content:space-between; gap:12px;
      border-bottom:1px solid #eef2f7;
    }
    .panel-head h5{ margin:0; font-weight: 900; }

    .stat-card{
      border:1px solid #e5e7eb;
      border-radius: 14px;
      background:#fff;
      padding: 16px 16px;
    }
    .stat-card .kpi{
      font-size: 28px; font-weight: 950; letter-spacing:-.5px;
    }
    .stat-card .label{ color:#6b7280; font-weight:700; }
    .stat-card .trend{
      font-weight:800; font-size: 13px;
      display:inline-flex; align-items:center; gap:6px;
      padding:.25rem .6rem;
      border-radius: 999px;
      border:1px solid transparent;
      background:#f3f4f6;
      color:#374151;
    }
    .trend.up{ background:#ecfdf3; border-color:#a7f3d0; color:#047857; }
    .trend.down{ background:#fff7ed; border-color:#fed7aa; color:#9a3412; }

    .table thead th{
      font-size: 13px;
      color:#6b7280;
      font-weight: 900;
      background:#fbfcfe;
      border-top:0;
    }
    .table td{ border-color:#eef2f7; font-size: 14px; color:#111827; }
  </style>
</head>

<body>
  <div class="app">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="brand">
        <div class="brand-badge">CO</div>
        <div>
          <div style="font-weight:950; font-size:18px;">Spodut</div>
          <div style="font-size:12px; color:#6b7280;">Admin Panel</div>
        </div>
      </div>

      <div class="nav-section-title">Menu</div>

      <a class="nav-item active" href="dashboard.html">
        <i class="bi bi-grid-3x3-gap"></i>
        <span>Dashboard</span>
      </a>

      <a class="nav-item" href="categories.html">
        <i class="bi bi-tag"></i>
        <span>Categories</span>
      </a>

      <div class="nav-section-title">Others</div>

      <a class="nav-item" href="#">
        <i class="bi bi-bag"></i>
        <span>Products</span>
      </a>
      <a class="nav-item" href="#">
        <i class="bi bi-receipt"></i>
        <span>Sales</span>
      </a>
      <a class="nav-item" href="#">
        <i class="bi bi-gear"></i>
        <span>Settings</span>
      </a>
    </aside>

    <!-- Main -->
    <main class="main">
      <div class="page-header">
        <h1 class="page-title">Dashboard</h1>

        <div class="d-flex align-items-center gap-2">
          <button class="btn btn-outline-secondary btn-sm rounded-circle" type="button" aria-label="Search">
            <i class="bi bi-search"></i>
          </button>
          <button class="btn btn-outline-secondary btn-sm rounded-circle" type="button" aria-label="User">
            <i class="bi bi-person"></i>
          </button>
        </div>
      </div>

      <!-- KPI row -->
      <div class="row g-3 mb-3">
        <div class="col-12 col-md-6 col-lg-3">
          <div class="stat-card">
            <div class="label">Total Products</div>
            <div class="kpi">1,284</div>
            <div class="trend up mt-2"><i class="bi bi-arrow-up-short"></i> +8.2% (7d)</div>
          </div>
        </div>

        <div class="col-12 col-md-6 col-lg-3">
          <div class="stat-card">
            <div class="label">Active Products</div>
            <div class="kpi">842</div>
            <div class="trend up mt-2"><i class="bi bi-arrow-up-short"></i> +3.1% (7d)</div>
          </div>
        </div>

        <div class="col-12 col-md-6 col-lg-3">
          <div class="stat-card">
            <div class="label">Draft Products</div>
            <div class="kpi">214</div>
            <div class="trend down mt-2"><i class="bi bi-arrow-down-short"></i> -1.4% (7d)</div>
          </div>
        </div>

        <div class="col-12 col-md-6 col-lg-3">
          <div class="stat-card">
            <div class="label">Monthly Revenue</div>
            <div class="kpi">$58,920</div>
            <div class="trend up mt-2"><i class="bi bi-arrow-up-short"></i> +6.0% (30d)</div>
          </div>
        </div>
      </div>

      <!-- Main table -->
      <section class="panel">
        <div class="panel-head">
          <h5>Recent Products</h5>
          <div class="d-flex gap-2">
            <button class="btn btn-outline-secondary btn-sm" type="button">
              <i class="bi bi-arrow-clockwise me-1"></i> Refresh
            </button>
          </div>
        </div>

        <div class="p-2 px-2">
          <div class="table-responsive">
            <table class="table align-middle mb-0">
              <thead>
                <tr>
                  <th style="width:44px;">
                    <input class="form-check-input" type="checkbox" aria-label="Select all">
                  </th>
                  <th>Product</th>
                  <th>Category</th>
                  <th style="width:140px;">Price</th>
                  <th style="width:120px;">Stock</th>
                  <th style="width:160px;">Status</th>
                  <th class="text-end" style="width:120px;">Actions</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                  <td><div class="fw-bold">T-Shirt</div></td>
                  <td>Women Cloths</td>
                  <td>$79.80</td>
                  <td>79</td>
                  <td><span class="badge rounded-pill text-bg-success-subtle border border-success-subtle text-success fw-bold">Active</span></td>
                  <td class="text-end"><a class="text-decoration-none fw-bold text-primary" href="#">Det</a></td>
                </tr>
                <tr>
                  <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                  <td><div class="fw-bold">Shirt</div></td>
                  <td>Man Cloths</td>
                  <td>$76.89</td>
                  <td>86</td>
                  <td><span class="badge rounded-pill text-bg-primary-subtle border border-primary-subtle text-primary fw-bold">Scheduled</span></td>
                  <td class="text-end"><a class="text-decoration-none fw-bold text-primary" href="#">Det</a></td>
                </tr>
                <tr>
                  <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                  <td><div class="fw-bold">Pant</div></td>
                  <td>Kid Cloths</td>
                  <td>$86.65</td>
                  <td>74</td>
                  <td><span class="badge rounded-pill text-bg-warning-subtle border border-warning-subtle text-warning fw-bold">Draft</span></td>
                  <td class="text-end"><a class="text-decoration-none fw-bold text-primary" href="#">Det</a></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </section>
    </main>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>