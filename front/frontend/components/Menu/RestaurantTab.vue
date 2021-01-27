<template>
  <section class="restaurant-tab">
    <div class="container">
      <div class="row">
        <div class="nav-tab col-10 container">
          <div class="row justify-content-around align-items-end">
            <div class="desktop-nav row justify-content-around align-items-end">
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
            <div class="mobile-nav">
              <div class="label">
                <i class="fas fa-chevron-left" />
                <p>Menu</p>
                <i class="fas fa-chevron-right" />
              </div>
              <div class="dots">
                <i class="fas fa-circle active" />
                <i class="fas fa-circle" />
                <i class="fas fa-circle" />
                <i class="fas fa-circle" />
                <i class="fas fa-circle" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<style scoped>
.nav-tab {
    margin-top: -2px;
    height: 5vh;
    width: 100%;
    border-bottom-right-radius: 8px;
    border-bottom-left-radius: 8px;
    background-color: var(--hard-orange);
    border-bottom: 1px solid grey;
    display: flex;
    align-items: flex-end;
}
.nav-tab .row {
    width: 100%;
    margin: 0;
}
.restaurant-tab-item {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 4vh;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    cursor: pointer;
    background-color: var(--transparent-white);
}
.restaurant-tab-item:hover {
    background-color: var(--lightest-orange);
}
.restaurant-tab-item.active {
    background-color: var(--lightest-orange);
    box-shadow: 0 1px 2px grey inset;
}
.mobile-nav {
    display: none;
}
@media only screen and (max-width: 468px) {
    .restaurant-tab > .container {
        box-sizing: border-box;
    }
    .nav-tab {
        width: 200px;
    }
    .nav-tab .row {
        align-items: center !important;
        justify-content: center !important;
        height: 100%;
    }
    .desktop-nav {
        display: none;
    }
    .mobile-nav {
        display: block;
        text-align: center;
    }
    .label {
        display: flex;
        align-items: center;
    }
    .label * {
        float: left;
    }
    .label .fa-chevron-left {
        margin-right: 10px;
        margin-left: -10px;
        margin-bottom: 2px;
    }
    .label .fa-chevron-right {
        margin-left: 10px;
        margin-right: -10px;
        margin-bottom: 2px;
    }
    .mobile-nav p {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 5vh;
        width: 120px;
        border-top-left-radius: 8px;
        border-top-right-radius: 8px;
        background-color: var(--transparent-white);
        margin-bottom: 2px;
        margin-left: auto;
        margin-right: auto;
        position: relative;
        bottom: 1px;
        box-shadow: 0 1px 2px grey inset;
    }
    .fa-circle {
        color: black;
        opacity: 0.4;
        font-size: 12px;
        margin-left: 2px;
        margin-right: 2px;
    }
    .fa-circle.active {
        opacity: 1;
    }
}
