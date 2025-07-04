# Shopping Cart System
A Java-based e-commerce cart implementation with product management and checkout functionality.

## Abstract
This system handles product catalogs, shopping carts, and checkout processes. Built to manage perishable goods with expiration dates, shippable items with weight calculations, and customer transactions.

## Features:
- Product Types: Perishable and non-perishable products with expiration tracking

- Inventory Management: Real-time stock validation and quantity control

- Smart Cart: Automatic duplicate consolidation and balance verification

- Shipping Integration: Weight-based calculations and automated notifications

- Checkout Process: Receipt generation and inventory updates.

## Architecture
Built around Product hierarchy, Cart management, and separate services for checkout and shipping operations.

### Normal Checkout && its output

<div align="center">
  <img src="./imgs/normal-checkout.png" alt="code" width="400"/>
  <img src="./imgs/normal-checkout-output.png" alt="output" width="400"/>
</div>

### Insufficient balance && its output

<div align="center">
  <img src="./imgs/insuffecient-balance.png" alt="code" width="400"/>
  <img src="./imgs/insuffecient-balance-output.png" alt="output" width="400"/>
</div>

### Empty Cart && its output

<div align="center">
  <img src="./imgs/empty-cart.png" alt="code" width="400"/>
  <img src="./imgs/empty-cart-output.png" alt="output" width="400"/>
</div>

### Expired Product

<div align="center">
  <img src="./imgs/expired-product-.png" alt="code" width="400"/>
</div>

### Out of Stock

<div align="center">
  <img src="./imgs/out-of-stck.png" alt="code" width="400"/>
</div>