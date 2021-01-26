<template>
  <div class="row">
    <div class="food-list col-10 container">
      <div v-for="food in activeFoods" :key="food.id" class="food-item-container">
        <div class="separator-horizontal" />
        <food-item :food="food" />
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
  },
  computed: {
    activeFoods () {
      return this.foods.filter(food => food.available === true)
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
.food-item-container:nth-child(1) > .separator-horizontal {
    margin-top: 5px;
}
.food-list {
    background-color: var(--transparent-white);
}
</style>
