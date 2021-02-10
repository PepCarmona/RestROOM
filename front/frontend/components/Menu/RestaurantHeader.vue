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
                {{ restaurant.name }}
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
                <a :href="restaurant.website" target="_blank" rel="noopener noreferrer">
                  {{ formattedWeb }}
                </a>
              </p>
              <p>
                <i class="fas fa-phone-alt" />
                <a :href="restaurant.phone">
                  {{ restaurant.phone }}
                </a>
              </p>
              <p>
                <i class="far fa-envelope" />
                <a href="mailto:">
                  {{ restaurant.email }}
                </a>
              </p>
            </div>
          </div>
          <div class="row">
            <div class="header-address col-auto">
              <p>
                <i class="fas fa-map-marker-alt" />
                <a href="">
                  {{ restaurant.address }}
                </a>
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
<script>
export default {
  props: {
    restaurant: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  computed: {
    formattedWeb () {
      const http = 'http://www.'
      const https = 'https://www.'
      // const website = this.restaurant.website
      const website = 'http://www.example.com '
      let formatted
      if (website.includes(http)) {
        formatted = website.slice(http.length)
      } else if (website.includes(https)) {
        formatted = website.slice(https.length)
      } else {
        formatted = website
      }
      return formatted
    }
  }
}
</script>
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
    z-index: 9;
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
@media only screen and (max-width: 468px) {
    .restaurant-header > .container {
        box-sizing: border-box;
    }
    .header-foto {
        height: 60vh;
    }
    .header-basic {
        width: 100%;
    }
    .header-basic .row:nth-child(2) {
        margin-top: 5px;
        justify-content: space-between !important;
    }
    .header-food-type, .header-rating {
        width: auto;
    }
    .header-info {
        width: 100%;
    }
    .header-logo {
        width: 120px;
        height: 120px;
    }
    .header-name {
        width: 60%;
    }
    .header-info {
        border-left: none;
        margin-top: 20px;
    }
    .header-info .row div {
        display: inline-block;
        margin-bottom: 0;
    }
    .header-info p {
        width: 100%;
    }
}
</style>
