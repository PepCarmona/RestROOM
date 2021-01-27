<template>
  <div class="row">
    <div class="food-list col-10 container">
      <div v-for="food in foods" :key="food.id" class="food-item-container">
        <food-item :food="food" :class="{ disabled: !food.available }" />
      </div>
    </div>
  </div>
</template>
<script>
import FoodItem from '~/components/Menu/FoodItem.vue'

export default {
  components: {
    FoodItem
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
<style scoped>
.food-list {
    margin-top: 10px;
    padding: 0;
}
</style>
