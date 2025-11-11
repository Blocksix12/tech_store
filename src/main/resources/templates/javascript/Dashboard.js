document.addEventListener('DOMContentLoaded', function () {
    // Fake data demo cho bảng đơn hàng
    const orders = [
        { id: 'DH001', customer: 'Nguyễn Văn A', products: 3, total: '1.500.000₫', status: 'completed', date: '2025-11-11' },
        { id: 'DH002', customer: 'Trần Thị B', products: 2, total: '850.000₫', status: 'processing', date: '2025-11-10' },
        { id: 'DH003', customer: 'Lê Văn C', products: 5, total: '2.300.000₫', status: 'pending', date: '2025-11-09' },
        { id: 'DH004', customer: 'Phạm Thị D', products: 1, total: '450.000₫', status: 'cancelled', date: '2025-11-08' },
    ];

    const tbody = document.querySelector('table tbody');

    orders.forEach(order => {
        const tr = document.createElement('tr');

        tr.innerHTML = `
            <td>${order.id}</td>
            <td>${order.customer}</td>
            <td>${order.products}</td>
            <td>${order.total}</td>
            <td><span class="status-badge ${order.status}">${order.status.charAt(0).toUpperCase() + order.status.slice(1)}</span></td>
            <td>${order.date}</td>
            <td>
                <a href="/admin/orders/${order.id}" class="btn btn-sm btn-outline-primary">Xem</a>
            </td>
        `;

        tbody.appendChild(tr);
    });

    // Fake data demo cho sản phẩm bán chạy
    const topProducts = [
        { name: 'Áo thun nam', sold: 125 },
        { name: 'Quần jean nữ', sold: 98 },
        { name: 'Giày sneaker', sold: 75 },
    ];

    const topProductsContainer = document.querySelectorAll('.chart-container')[0].querySelector('div');
    topProducts.forEach(product => {
        const div = document.createElement('div');
        div.textContent = `${product.name} - ${product.sold} bán ra`;
        topProductsContainer.appendChild(div);
    });

    // Fade-in delayed animation
    const fadeElements = document.querySelectorAll('.fade-in-up');
    fadeElements.forEach((el, i) => {
        el.style.animationDelay = `${i * 0.1}s`;
    });
});
