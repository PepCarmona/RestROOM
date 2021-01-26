<template>
  <div>
    <restaurant-header :restaurant="restaurant" />
    <restaurant-tab />
    <restaurant-menu :foods="foods" :menus="menus" :types="types" :allergens="allergens" :categories="categories" />
    <shopping-cart />
  </div>
</template>

<script>

import RestaurantHeader from '~/components/Menu/RestaurantHeader.vue'
import RestaurantMenu from '~/components/Menu/RestaurantMenu.vue'
import RestaurantTab from '~/components/Menu/RestaurantTab.vue'
import ShoppingCart from '~/components/Menu/ShopingCart.vue'

export default {
  components: {
    RestaurantHeader,
    RestaurantMenu,
    RestaurantTab,
    ShoppingCart
  },
  async asyncData (ctx) {
    return {
      restaurant: await ctx.app.$services.public.findRestaurantById(3),
      foods: await ctx.app.$services.food.findAll(),
      menus: await ctx.app.$services.menu.findAllMenus(),
      types: await ctx.app.$services.menu.findAllFoodTypes(),
      allergens: await ctx.app.$services.menu.findAllAllergens(),
      categories: await ctx.app.$services.menu.findAllCategories()
    }
  },
  data () {
    return {
      restaurant: {
        type: Object
      },
      foods: {
        type: Array
      },
      menus: {
        type: Array
      },
      types: {
        type: Array
      },
      allergens: {
        type: Array
      },
      categories: {
        type: Array
      }
    }
  }
}
</script>
