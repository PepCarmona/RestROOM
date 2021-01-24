<template>
  <div>
    <restaurant-header />
    <restaurant-tab />
    <restaurant-menu :foods="foods" />
  </div>
</template>

<script>

import RestaurantHeader from '~/components/Menu/RestaurantHeader.vue'
import RestaurantMenu from '~/components/Menu/RestaurantMenu.vue'
import RestaurantTab from '~/components/Menu/RestaurantTab.vue'

export default {
  components: {
    RestaurantHeader,
    RestaurantMenu,
    RestaurantTab
  },
  async asyncData (ctx) {
    return {
      foods: await ctx.app.$services.food.findAll()
    }
  },
  data () {
    return {
      foods: {
        type: Array
      }
    }
  }
}
</script>
