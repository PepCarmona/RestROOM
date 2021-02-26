<template>
  <div>
    <restaurant-header />
    <restaurant-menu
      :menus="activeMenus"
      :picked-menu="pickedMenu"
      @add-to-cart="addToCart"
    />
    <shopping-cart ref="shoppingCart" />
  </div>
</template>

<script>

import RestaurantHeader from '~/components/Menu/RestaurantHeader.vue'
import RestaurantMenu from '~/components/Menu/RestaurantMenu.vue'
import ShoppingCart from '~/components/Menu/ShopingCart.vue'

export default {
  components: {
    RestaurantHeader,
    RestaurantMenu,
    ShoppingCart
  },
  async fetch () {
    const selectedRestaurant = this.$store.state.selectedRestaurant
    this.activeMenus = await this.$services.menu.findActiveMenusByRestaurant(selectedRestaurant.id)
  },
  data () {
    return {
      pickedFood: {
        type: Object
      },
      activeMenus: []
    }
  },
  computed: {
    pickedMenu () {
      return this.activeMenus[0]
    }
  },
  methods: {
    addToCart (food) {
      this.pickedFood = food
      this.$refs.shoppingCart.addToCart(this.pickedFood)
    }
  }
}
</script>
