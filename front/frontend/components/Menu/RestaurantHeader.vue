<template>
  <section class="restaurant-header">
    <section class="header-foto">
      <div class="open-close">
        opened
      </div>
    </section>
    <div class="container">
      <div class="row align-items-center">
        <div class="header-basic col-4">
          <div class="row align-items-center">
            <div class="header-logo col-3">
              foto
            </div>
            <div class="header-name col-9">
              <h1 class="display-6">
                Sa Fàbrica
              </h1>
            </div>
          </div>
          <div class="row justify-content-end">
            <div class="header-food-type col-8">
              Food1, Food2
            </div>
            <div class="header-rating col-4">
              <i class="fas fa-star" />
              <i class="fas fa-star" />
              <i class="fas fa-star" />
              <i class="fas fa-star-half-alt" />
              <i class="far fa-star" />
            </div>
          </div>
        </div>
        <div class="header-info col-8">
          <div class="row">
            <div class="header-contact col-auto">
              <p>
                <i class="fas fa-laptop" />
                <a href="http://" target="_blank" rel="noopener noreferrer">www.example.com</a>
              </p>
              <p>
                <i class="fas fa-phone-alt" />
                <a href="tel:+">666-666-666</a>
              </p>
              <p>
                <i class="far fa-envelope" />
                <a href="mailto:">example@example.com</a>
              </p>
            </div>
          </div>
          <div class="row">
            <div class="header-address col-auto">
              <p>
                <i class="fas fa-map-marker-alt" />
                <a href="">C/Example, Nº</a>
              </p>
              <p>
                <i class="far fa-clock" />
                <a href="">hh:mm - hh:mm</a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<style scoped>
.header-foto {
    height: 40vh;
    width: 100vw;
    background-image: url("/img/restaurant-header-1.jpg");
    background-size: cover;
    background-position: 0% 40%;
    z-index: -1;
}
.restaurant-header {
    background-color: var(--hard-orange);
}
.restaurant-header > .container > .row {
    padding: 10px;
}
.header-basic {
    padding: 10px;
}
.header-basic .row:nth-child(1) {
    margin-bottom: 5px;
}
.header-logo {
    height: 80px;
    width: 80px;
    margin-left: 1vw;
    background-color: paleturquoise;
}
.header-food-type {
    text-align: end;
}
.header-info {
    border-left: 1px solid black;
}
.header-info .row div {
    width: 100%;
    display: flex;
    justify-content: space-around;
}
.header-info p {
    float: left;
    margin-right: 30px;
}
.header-info a {
    color: black;
    text-decoration: none;
}
.header-info a:hover {
    color: var(--lightest-orange);
}
.header-contact {
    margin-bottom: 10px;
}
</style>
