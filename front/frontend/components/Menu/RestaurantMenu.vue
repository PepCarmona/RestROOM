<template>
  <section class="restaurant-menu">
    <div class="container">
      <menu-filters />
      <food-list :foods="foods" />
    </div>
  </section>
</template>
<script>
import MenuFilters from '~/components/Menu/MenuFilters.vue'
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
    }
  }
}
</script>
