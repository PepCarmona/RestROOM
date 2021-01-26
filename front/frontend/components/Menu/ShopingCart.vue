<template>
  <section class="cart">
    <button class="btn shopping-cart">
      <i class="fa fa-shopping-cart" />
      <i class="fa fa-circle" />
      <i class="fas fa-chevron-right chevron-1" />
      <i class="fas fa-chevron-right chevron-2" />
    </button>
    <div class="shopping-list">
      <div class="shopping-list-header">
        <p>Items</p> <p>Qty</p>
      </div>
      <ul>
        <li class="shopping-list-item">
          <i class="far fa-times-circle" /> <p>Burger</p> <p>1</p>
        </li>
        <li class="shopping-list-item">
          <p>Pizza</p> <p>3</p>
        </li>
        <li class="shopping-list-item">
          <p>Water</p> <p>2</p>
        </li>
        <li class="shopping-list-item">
          <p>Beer</p> <p>2</p>
        </li>
        <li class="shopping-list-item">
          <p>Brownie</p> <p>4</p>
        </li>
      </ul>
      <div class="shopping-list-total">
        <p>Total: </p><p>30 €</p>
      </div>
      <div class="shopping-buttons">
        <button class="btn shopping-list-pay">
          Pay
        </button>
        <button class="btn shopping-list-clean">
          <i class="fa fa-trash" />
        </button>
      </div>
    </div>
  </section>
</template>
<style scoped>
.cart {
    position: fixed;
    top: 150px;
    right: -250px;
    height: auto;
    width: 300px;
}
button.shopping-cart {
    background-color: var(--hard-orange);
    height: 40px;
    width: 320px;
    border-radius: 25px;
    position: relative;
    top: 0;
    text-align: left;
    padding-left: 15px;
    padding-top: 10px;
    box-shadow: 0 0 5px black;
    z-index: 9;
}
.shopping-cart .fa-shopping-cart {
    font-size: 20px;
}
.shopping-cart .fa-circle {
    color: white;
    font-size: 8px;
    position: absolute;
    top: 8%;
    left: 35px;
}
.chevron-1 {
    position: absolute;
    top: 13px;
    right: 40px;
}
.chevron-2 {
    font-size: 25px;
    position: absolute;
    top: 8px;
    right: 30px;
}
.shopping-list {
    display: none;
    position: relative;
    left: 20px;
    height: auto;
    width: 260px;
    padding: 10px;
    border-bottom-left-radius: 10px;
    background-color: rgba(201, 150, 55, 0.856);
    box-shadow: 0 0 5px black;
}
.shopping-list ul {
    list-style-type: none;
    height: 200px;
    width: 280px;
    padding-left: 0;
    padding-top: 15px;
    margin-bottom: 0;
    margin-left: -10px;
    margin-right: -10px;
    overflow-y: auto;
    background-color: rgba(255, 233, 194, 0.842);
    border-top: 1px solid white;
    border-bottom: 1px solid white;
    box-shadow: 0 10px 5px  -10px black inset, 0 -10px 5px -10px black inset;
}
::-webkit-scrollbar {
    width: 3px;
}
::-webkit-scrollbar-track {
    background-color: transparent;
}
::-webkit-scrollbar-thumb {
    background-color: var(--hard-orange);
}
.shopping-list ul li {
    height: 40px;
}
.shopping-list-header {
    color: white;
    padding-top: 12px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.shopping-list-header p {
    margin-bottom: 0;
}
.shopping-list-header p:nth-child(1) {
    padding-left: 10px;
}
.shopping-list-header p:nth-last-child(1) {
    padding-right: 10px;
    border-left: 1px solid white;
    padding-left: 12px;
}
.shopping-list-item {
    display: flex;
    justify-content: space-between;
    margin-bottom: 20px;
    width: 100%;
    border-bottom: 1px solid black;
}
.shopping-list-item i {
    margin-top: 12px;
    margin-left: 5px;
}
.shopping-list-item p {
    height: 100%;
    display: flex;
    align-items: center;
}
.shopping-list-item p:nth-child(1){
    padding-left: 5px;
}
.shopping-list-item p:nth-last-child(1){
    justify-content: center;
    margin-right: 10px;
    border-left: 1px solid black;
    padding-left: 20px;
    padding-right: 15px;
}
.shopping-list-total {
    color: white;
    padding-top: 10px;
    text-align: right;
    padding-right: 5px;
    display: flex;
    justify-content: flex-end;
    align-content: center;
}
.shopping-list-total p:nth-child(1) {
    padding-top: 15px;
}
.shopping-list-total p:nth-last-child(1) {
    margin-left: 10px;
    font-size: 30px;
}
.shopping-buttons {
    width: 100%;
    height: 60px;
    display: flex;
    justify-content: center;
}
.shopping-buttons button {
    height: 100%;
    border: 2px solid var(--light-orange);
    border-radius: 0px;
    box-shadow: 0 0 2px black;
}
.shopping-list-pay {
    width: 85%;
    border-right: none !important;
    border-top-left-radius: 30px !important;
    border-bottom-left-radius: 10px !important;
    font-size: 30px;
    background-color: white;
}
.shopping-list-clean {
    width: auto;
    border-left: none !important;
    border-top-right-radius: 10px !important;
    border-bottom-right-radius: 30px !important;
    font-size: 15px;
    background-color: var(--light-orange);
}
</style>
