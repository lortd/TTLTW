<!doctype html>
<html lang="vi">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Categories</title>

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
    .brand{ padding: 18px 18px 10px; display:flex; align-items:center; gap:12px; }
    .brand-badge{
      width:36px;height:36px;border-radius:10px;
      background:#4f46e5;color:#fff;
      display:flex; align-items:center; justify-content:center;
      font-weight:800; letter-spacing:.5px;
    }
    .nav-section-title{ font-size:12px; color:#6b7280; padding:10px 18px 6px; }
    .nav-item{
      display:flex; align-items:center; gap:12px;
      padding: 10px 18px; margin: 2px 10px;
      border-radius:12px;
      color:#374151; text-decoration:none;
      font-weight: 600;
    }
    .nav-item:hover{ background:#f3f4f6; color:#111827; }
    .nav-item.active{ background:#eef2ff; color:#4f46e5; border:1px solid #e0e7ff; }

    .main{ flex:1; padding: 22px 22px 30px; }
    .page-header{ display:flex; align-items:center; justify-content:space-between; gap:16px; margin-bottom: 14px; }
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
    .panel-head h5{ margin:0; font-weight: 950; }

    .table thead th{
      font-size: 13px; color:#6b7280; font-weight: 950;
      background:#fbfcfe; border-top:0;
    }
    .table td{ border-color:#eef2f7; font-size: 14px; color:#111827; }

    /* Category tree */
    .tree-wrap{ padding: 14px; }
    .tree-item{
      display:flex; align-items:center; gap:10px;
      padding: 9px 10px;
      border-radius: 12px;
      color:#111827;
      font-weight: 700;
    }
    .tree-item:hover{ background:#f3f4f6; }
    .indent-0{ margin-left:0; }
    .indent-1{ margin-left:18px; }
    .indent-2{ margin-left:36px; }
    .cat-pill{
      font-size: 12px;
      font-weight: 900;
      padding: .25rem .55rem;
      border-radius: 999px;
      border: 1px solid #e5e7eb;
      color:#374151;
      background:#fff;
      white-space: nowrap;
    }
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

      <a class="nav-item" href="dashboard.html">
        <i class="bi bi-grid-3x3-gap"></i>
        <span>Dashboard</span>
      </a>

      <a class="nav-item active" href="categories.html">
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
        <h1 class="page-title">Categories</h1>

        <div class="d-flex align-items-center gap-2">
          <button class="btn btn-outline-secondary btn-sm rounded-circle" type="button" aria-label="Search">
            <i class="bi bi-search"></i>
          </button>
          <button class="btn btn-outline-secondary btn-sm rounded-circle" type="button" aria-label="User">
            <i class="bi bi-person"></i>
          </button>
        </div>
      </div>

      <!-- Tree + table -->
      <div class="row g-3">
        <div class="col-12 col-lg-4">
          <section class="panel h-100">
            <div class="panel-head">
              <h5>Category Tree</h5>
              <button class="btn btn-sm btn-outline-secondary" type="button">
                <i class="bi bi-plus-lg me-1"></i> Add
              </button>
            </div>

            <div class="tree-wrap">
              <!-- Level 0 -->
              <div class="tree-item indent-0">
                <i class="bi bi-folder-fill text-primary"></i>
                <span>Women Cloths</span>
                <span class="cat-pill ms-auto">12</span>
              </div>

              <!-- Level 1 -->
              <div class="tree-item indent-1">
                <i class="bi bi-folder-fill text-primary"></i>
                <span>Shirts</span>
                <span class="cat-pill ms-auto">5</span>
              </div>

              <div class="tree-item indent-2">
                <i class="bi bi-box"></i>
                <span>T-Shirt</span>
                <span class="cat-pill ms-auto">3</span>
              </div>

              <div class="tree-item indent-2">
                <i class="bi bi-box"></i>
                <span>Half Shirt</span>
                <span class="cat-pill ms-auto">2</span>
              </div>

              <div class="tree-item indent-1">
                <i class="bi bi-folder-fill text-primary"></i>
                <span>Outerwear</span>
                <span class="cat-pill ms-auto">7</span>
              </div>

              <div class="tree-item indent-2">
                <i class="bi bi-box"></i>
                <span>Light Jacket</span>
                <span class="cat-pill ms-auto">4</span>
              </div>

              <div class="tree-item indent-2">
                <i class="bi bi-box"></i>
                <span>Sweater</span>
                <span class="cat-pill ms-auto">3</span>
              </div>

              <hr class="my-3">

              <!-- Another Level 0 -->
              <div class="tree-item indent-0">
                <i class="bi bi-folder-fill text-success"></i>
                <span>Man Cloths</span>
                <span class="cat-pill ms-auto">10</span>
              </div>

              <div class="tree-item indent-1">
                <i class="bi bi-folder-fill text-success"></i>
                <span>Pants</span>
                <span class="cat-pill ms-auto">4</span>
              </div>

              <div class="tree-item indent-2">
                <i class="bi bi-box"></i>
                <span>Pant</span>
                <span class="cat-pill ms-auto">4</span>
              </div>

              <div class="tree-item indent-1">
                <i class="bi bi-folder-fill text-success"></i>
                <span>Tops</span>
                <span class="cat-pill ms-auto">6</span>
              </div>

              <div class="tree-item indent-2">
                <i class="bi bi-box"></i>
                <span>Shirt</span>
                <span class="cat-pill ms-auto">3</span>
              </div>

              <div class="tree-item indent-2">
                <i class="bi bi-box"></i>
                <span>Sweater</span>
                <span class="cat-pill ms-auto">3</span>
              </div>
            </div>
          </section>
        </div>

        <div class="col-12 col-lg-8">
          <section class="panel">
            <div class="panel-head">
              <h5>Categories list</h5>
              <div class="d-flex gap-2">
                <button class="btn btn-outline-secondary btn-sm" type="button">
                  <i class="bi bi-funnel me-1"></i> Filter
                </button>
                <button class="btn btn-primary btn-sm" type="button">
                  <i class="bi bi-plus-lg me-1"></i> Add Category
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
                      <th style="min-width:260px;">Category</th>
                      <th style="width:160px;">Parent</th>
                      <th style="width:140px;">Level</th>
                      <th style="width:140px;">Products</th>
                      <th class="text-end" style="width:120px;">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <!-- level 0 -->
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td><span class="fw-bold">Women Cloths</span></td>
                      <td class="text-muted">—</td>
                      <td>0</td>
                      <td>12</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td><span class="fw-bold">Man Cloths</span></td>
                      <td class="text-muted">—</td>
                      <td>0</td>
                      <td>10</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>

                    <!-- level 1 -->
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Shirts</td>
                      <td>Women Cloths</td>
                      <td>1</td>
                      <td>5</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Outerwear</td>
                      <td>Women Cloths</td>
                      <td>1</td>
                      <td>7</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>

                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Pants</td>
                      <td>Man Cloths</td>
                      <td>1</td>
                      <td>4</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Tops</td>
                      <td>Man Cloths</td>
                      <td>1</td>
                      <td>6</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>

                    <!-- level 2 -->
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>T-Shirt</td>
                      <td>Shirts</td>
                      <td>2</td>
                      <td>3</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Half Shirt</td>
                      <td>Shirts</td>
                      <td>2</td>
                      <td>2</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>

                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Light Jacket</td>
                      <td>Outerwear</td>
                      <td>2</td>
                      <td>4</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Sweater</td>
                      <td>Outerwear</td>
                      <td>2</td>
                      <td>3</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>

                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Pant</td>
                      <td>Pants</td>
                      <td>2</td>
                      <td>4</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>
                    <tr>
                      <td><input class="form-check-input" type="checkbox" aria-label="Select row"></td>
                      <td>Shirt</td>
                      <td>Tops</td>
                      <td>2</td>
                      <td>3</td>
                      <td class="text-end"><a href="#" class="text-decoration-none fw-bold text-primary">Det</a></td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </section>
        </div>
      </div>
    </main>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>	