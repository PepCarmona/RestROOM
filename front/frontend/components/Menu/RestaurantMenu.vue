<template>
  <section class="restaurant-menu">
    <div class="container">
      <div class="row">
        <div class="menu-tab col-10 container">
          <div class="menu-filters row justify-content-around align-items-center">
            <menu-filter v-model="pickedMenu" :content="menus" text="Menus" />
            <menu-filter-multi v-model="pickedFoodType" :content="types" text="Food Types" @input="inputFoodTypes" />
            <menu-filter-multi v-model="pickedAllergen" :content="allergens" text="Allergens" @input="inputAllergens" />
            <menu-filter text="Order By" />
          </div>
          <menu-categories v-model="pickedCategory" />
        </div>
      </div>
      <food-list :foods="filteredFoods" @add-to-cart="addToCart" />
    </div>
  </section>
</template>
<script>
import MenuFilter from '~/components/Menu/Filters/MenuFilter.vue'
import MenuFilterMulti from '~/components/Menu/Filters/MenuFilterMulti.vue'
import FoodList from '~/components/Menu/FoodList.vue'

export default {
  components: {
    MenuFilter,
    MenuFilterMulti,
    FoodList
  },
  props: {
    menus: {
      type: Array,
      default () {
        return []
      }
    },
    pickedMenu: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  async fetch () {
    const selectedRestaurant = this.$store.state.selectedRestaurant
    this.foods = await this.$services.food.findFoodByRestaurant(selectedRestaurant.id)
    this.types = await this.$services.menu.findAllFoodTypes()
    this.allergens = await this.$services.menu.findAllAllergens()
    this.pickedCategory = await this.$services.menu.findCategoryById(5)
  },
  data () {
    return {
      foods: [],
      types: [],
      allergens: [],
      pickedCategory: {
        type: Object
      },
      pickedFoodTypes: [],
      pickedFoodType: {
        type: Object
      },
      pickedAllergens: [],
      pickedAllergen: {
        type: Object
      }
    }
  },
  computed: {
    filteredFoods () {
      let filteredFoods = this.foods
      const pickedMenu = this.pickedMenu
      const pickedCategory = this.pickedCategory
      const pickedFoodTypes = this.pickedFoodTypes
      const pickedAllergens = this.pickedAllergens
      filteredFoods = filteredFoods.filter(food => food.menus.some(menu => menu.menu_ID === pickedMenu.id))
      filteredFoods = filteredFoods.filter(food => food.category.id === pickedCategory.id)
      if (pickedFoodTypes.length > 0) {
        filteredFoods = filteredFoods.filter(food => pickedFoodTypes.some(foodType => foodType.id === food.type.food_type_ID))
      }
      filteredFoods = filteredFoods.filter(food => !food.allergens.some(foodAllergen => pickedAllergens.some(allergen => allergen.id === foodAllergen.allergen_ID)))
      return filteredFoods
    }

  },
  methods: {
    inputFoodTypes (foodType) {
      let found = false
      const list = this.pickedFoodTypes
      list.forEach(function (element, index) {
        if (element.id === foodType.id) {
          found = true
          list.splice(index, 1)
          return false
        }
      })
      if (!found) {
        list.push(foodType)
      }
    },
    inputAllergens (allergen) {
      let found = false
      const list = this.pickedAllergens
      list.forEach(function (element, index) {
        if (element.id === allergen.id) {
          found = true
          list.splice(index, 1)
          return false
        }
      })
      if (!found) {
        list.push(allergen)
      }
    },
    addToCart (food) {
      this.$emit('add-to-cart', food)
    }
  }
}
</script>
<style scoped>
.menu-filters {
  margin-bottom: 50px;
}
.menu-filters > div {
    margin: 1px;
    padding-top: 5px;
    position: relative;
    display: inline-block;
}
@media only screen and (max-width: 1000px){
    .restaurant-menu .container, .restaurant-menu .col-10{
        width: 90%;
        max-width: none;
    }
}
</style>
