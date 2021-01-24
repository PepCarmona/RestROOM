<template>
  <section class="restaurant-tab">
    <div class="container">
      <div class="row">
        <div class="nav-tab col-10 container">
          <div class="row justify-content-center align-items-center">
            <div class="restaurant-tab-item tab-carta col-2 active">
              Menu
            </div>
            <div class="restaurant-tab-item tab-booking col-2">
              Reserva
            </div>
            <div class="restaurant-tab-item tab-rating col-2">
              Opiniones
            </div>
            <div class="restaurant-tab-item tab-offer col-2">
              Ofertas
            </div>
            <div class="restaurant-tab-item tab-info col-2">
              Info
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<style scoped>
.restaurant-tab {
    margin-top: 10px;
}
.nav-tab {
    margin-top: 4vh;
    height: 5vh;
    border-top-right-radius: 10px;
    border-top-left-radius: 10px;
    border-bottom: 1px solid var(--border-gray);
    background-color: var(--transparent-white);
}
.restaurant-tab-item {
    margin-top: 1vh;
    margin-left: 1vw;
    margin-right: 1vw;
    text-align: center;
    height: 4vh;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom: 1px solid var(--border-gray);
    cursor: pointer;
    background-color: var(--transparent-white);
}
.restaurant-tab-item.active {
    background-color: rgba(255, 166, 0, 0.65);
}
</style>
