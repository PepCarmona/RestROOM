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
      :picked-food-types="pickedFoodTypes"
      :picked-food-type="pickedFoodType"
      :picked-allergens="pickedAllergens"
      :picked-allergen="pickedAllergen"
      @add-to-cart="addToCart"
    />
    <shopping-cart ref="shoppingCart" />
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
  async fetch () {
    const selectedRestaurant = this.$store.state.selectedRestaurant
    this.restaurant = selectedRestaurant
    this.foods = await this.$services.food.findFoodByRestaurant(selectedRestaurant.id)
    this.activeMenus = await this.$services.menu.findActiveMenusByRestaurant(selectedRestaurant.id)
    this.types = await this.$services.menu.findAllFoodTypes()
    this.allergens = await this.$services.menu.findAllAllergens()
    this.categories = await this.$services.menu.findAllCategories()
    this.pickedCategory = await this.$services.menu.findCategoryById(5)
  },
  data () {
    return {
      restaurant: {
        type: Object
      },
      foods: [],
      pickedFood: {
        type: Object
      },
      activeMenus: [],
      types: [],
      allergens: [],
      categories: [],
      pickedFoodTypes: [],
      pickedFoodType: {
        type: Object
      },
      pickedAllergens: [],
      pickedAllergen: {
        type: Object
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
  },
  methods: {
    addToCart (food) {
      this.pickedFood = food
      this.$refs.shoppingCart.addToCart(this.pickedFood)
    }
  }
}
</script>
