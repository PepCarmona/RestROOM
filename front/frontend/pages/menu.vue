<template>
  <div>
    <restaurant-header :restaurant="restaurant" />
    <restaurant-tab />
    <restaurant-menu
      :foods="foods"
      :menus="activeMenus"
      :types="types"
      :allergens="allergens"
      :categories="categories"
      :picked-category="pickedCategory"
      :picked-menu="pickedMenu"
      :picked-types="pickedFoodTypes"
      :picked-allergens="pickedAllergens"
    />
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
      activeMenus: await ctx.app.$services.menu.findActiveMenus(),
      types: await ctx.app.$services.menu.findAllFoodTypes(),
      allergens: await ctx.app.$services.menu.findAllAllergens(),
      categories: await ctx.app.$services.menu.findAllCategories(),
      pickedFoodTypes: await ctx.app.$services.menu.findAllFoodTypes(),
      pickedAllergens: [],
      pickedCategory: await ctx.app.$services.menu.findCategoryById(5)
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
      activeMenus: {
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
      },
      pickedFoodTypes: {
        type: Array
      },
      pickedAllergens: {
        type: Array
      },
      pickedCategory: {
        type: Object
      }
    }
  },
  computed: {
    pickedMenu () {
      return this.activeMenus[0]
    }
  }
}
</script>
