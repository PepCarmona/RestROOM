<template>
  <div class="row">
    <div class="food-list col-10 container">
      <div class="separator-horizontal" />
      <food-item v-for="food in foods" :key="food.id" :food="food" />
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
.separator-horizontal {
    width: 60%;
    margin-left: auto;
    margin-right: auto;
    border-bottom: 2px solid black;
    margin-top: 20px;
    margin-bottom: 20px;
}
.separator-horizontal:nth-child(1) {
    margin-top: 5px;
}
.food-list {
    background-color: var(--transparent-white);
}
</style>
