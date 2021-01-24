<template>
  <div class="food-item row align-items-center justify-content-between">
    <div class="food-foto col-3">
      foto
    </div>
    <div class="food-body col">
      <div class="food-name">
        {{ food.name }}
      </div>
      <div class="food-description">
        description
      </div>
      <div class="food-type">
        {{ food.type }}
      </div>
      <div class="food-allergens">
        <div v-for="allergen in food.allergens" :key="allergen.id">
          {{ allergen }}
        </div>
      </div>
      <div class="food-buy">
        <p>
          {{ food.price }} €
        </p>
        <button class="btn">
          Add
        </button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    food: {
      type: Object,
      default () {
        return {}
      }
    }
  }
}
</script>
<style scoped>
.food-item {
    background-color: var(--transparent-white);
    padding: 10px;
    height: 180px;
    width: 95%;
    margin-left: auto;
    margin-right: auto;
}
.food-foto {
    height: 180px;
    width: 180px;
    background-color: paleturquoise;
}
.food-body {
    position: relative;
    display: flex;
    flex-wrap: wrap;
    margin-left: 20px;
    height: 100%;
}
.food-body > div {
    margin: 10px;
    padding: 5px;
    display: flex;
    align-items: center;
}
.food-name, .food-description {
    width: 100%;
}
.food-type, .food-allergens {
    width: 30%;
}
.food-allergens {
    justify-content: center;
}
.food-allergens div {
    margin-left: 5px;
    background-color: paleturquoise;
    height: 30px;
    width: 30px;
}
.food-buy {
    width: 22%;
    align-self: flex-end;
    align-items: flex-start !important;
    justify-content: flex-end;
    margin-right: 0 !important;
}
.food-buy p {
    background-color: var(--lightest-orange);
    border: 1px solid var(--hard-orange);
    border-top-left-radius: 5px;
    border-bottom-left-radius: 5px;
    height: 40px;
    width: 60px;
    display: flex;
    align-items: center;
    justify-content: center;
}
.food-buy button {
    background-color: var(--light-orange);
    border: 1px solid var(--hard-orange);
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
    border-left: none;
    height: 42px;
    width: 50px;
}
</style>
