<template>
  <section class="restaurants">
    <div class="container">
      <div class="row justify-content-between">
        <div class="list-services-area col-3">
          <h5>SERVICES</h5>
          <form class="check-services hidden-checkbox">
            <service-item v-for="service in services" :key="service.id" :service="service" />
          </form>
        </div>
        <div class="col-8">
          <section class="list-restaurant">
            <h5>RESTAURANTS</h5>
            <restaurant-item v-for="restaurant in restaurants" :key="restaurant.id" :restaurant="restaurant" />
          </section>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import RestaurantItem from '~/components/List/RestaurantItem.vue'
import ServiceItem from '~/components/List/ServiceItem.vue'

export default {
  components: {
    RestaurantItem,
    ServiceItem
  },
  async asyncData (ctx) {
    return {
      restaurants: await ctx.app.$services.public.findAllRestaurants(),
      services: await ctx.app.$services.public.findAllServices()
    }
  },
  data () {
    return {
      restaurants: {
        type: Array
      },
      services: {
        type: Array
      }
    }
  }
}
</script>
<style scoped>
/* -- Services -- */
.restaurants {
    margin-top: 15vh;
}
.list-services-area {
    padding: 10px;
    border-radius: 5px;
    height: fit-content;
}
.list-services-area h5 {
    position: relative;
    padding: 12px 5px;
    text-align: center;
    height: 50px;
    border: 1px solid rgba(105, 105, 105, 0.199);
    border-radius: 3px;
    background-color: rgb(255, 231, 187);
    box-shadow: 0 1px 3px orange;
}
.check-services {
    height: 300px;
    padding: 5px;
    overflow-y: auto;
}
::-webkit-scrollbar {
    width: 5px;
}
::-webkit-scrollbar-track {
    background-color: transparent;
}
::-webkit-scrollbar-thumb {
    background-color: orange;
    border-radius: 10px;
}
/* -- RestaurantList -- */
.list-restaurant {
    background-color: rgba(255,255,255,0.322);
    margin-left: -1vw;
    margin-right: -1vw;
    border-radius: 10px;
    padding: 10px;
    height: fit-content;
}
.list-restaurant h5 {
    position: relative;
    margin-bottom: 20px;
    padding: 12px 5px;
    text-align: center;
    height: 50px;
    border: 1px solid rgba(105, 105, 105, 0.199);
    border-radius: 3px;
    background-color: rgb(255, 231, 187);
    box-shadow: 0 1px 3px orange;
}
</style>
