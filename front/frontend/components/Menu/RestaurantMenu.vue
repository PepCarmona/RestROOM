<template>
  <section class="restaurant-menu">
    <div class="container">
      <menu-filters :menus="menus" :types="types" :allergens="allergens" :categories="categories" />
      <food-list :foods="foods" />
    </div>
  </section>
</template>
<script>
import MenuFilters from '~/components/Menu/Filters/MenuFilters.vue'
import FoodList from '~/components/Menu/FoodList.vue'

export default {
  components: {
    MenuFilters,
    FoodList
  },
  props: {
    foods: {
      type: Array,
      default () {
        return []
      }
    },
    menus: {
      type: Array,
      default () {
        return []
      }
    },
    types: {
      type: Array,
      default () {
        return []
      }
    },
    allergens: {
      type: Array,
      default () {
        return []
      }
    },
    categories: {
      type: Array,
      default () {
        return []
      }
    }
  }
}
</script>
