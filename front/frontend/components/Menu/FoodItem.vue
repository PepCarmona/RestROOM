<template>
  <div class="food-item row align-items-center justify-content-between">
    <div class="food-foto col-3">
      foto
    </div>
    <div class="food-body col">
      <div class="food-name">
        {{ capitalFoodName }}
      </div>
      <div class="food-description">
        {{ capitalFoodDescription }}
      </div>
      <div class="food-type">
        {{ capitalFoodType }}
      </div>
      <div class="food-allergens">
        <div v-for="allergen in food.allergens" :key="allergen.id" :style="{ backgroundImage: `url('/img/allergens/`+allergen.allergen_ID+`.png')`}" />
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
  },
  computed: {
    capitalFoodType () {
      return this.food.type.name.charAt(0).toUpperCase() + this.food.type.name.slice(1)
    },
    capitalFoodName () {
      return this.food.name.charAt(0).toUpperCase() + this.food.name.slice(1)
    },
    capitalFoodDescription () {
      return this.food.description.charAt(0).toUpperCase() + this.food.description.slice(1)
    }
  }
}
</script>
<style scoped>
.food-item {
    background-color: var(--transparent-white);
    padding: 10px;
    min-height: 180px;
    margin-left: auto;
    margin-right: auto;
    box-shadow: 0px 0px 3px 1px grey;
    margin-top: 25px;
    margin-bottom: 25px;
    border-radius: 3px;
}
.food-item:hover {
    box-shadow: 0 0 5px 2px grey;
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
.food-name {
    font-size: 30px;
}
.food-type, .food-allergens {
    width: 30%;
}
.food-allergens {
    justify-content: center;
}
.food-allergens div {
    margin-left: 5px;
    background-size: contain;
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
.food-buy button:hover {
    box-shadow: 0 0 5px 1px grey;
}
.food-buy * {
    box-shadow: 0 0 5px gray;
}
.food-list .disabled{
    opacity: 0.5;
    background-color: rgb(168, 168, 168);
}
.food-list .disabled .food-buy * {
    opacity: 0.5;
    pointer-events: none;
}
@media only screen and (max-width: 1000px){
    .food-item {
        align-items: flex-start !important;
    }
    .food-foto {
        height: 150px;
        width: 150px;
    }
    .food-type, .food-allergens {
        margin-left: -150px;
    }
}
@media only screen and (max-width: 468px){
    .food-foto {
        width: 100%;
        padding-top: 100%;
    }
    .food-body {
        margin: 0px;
        padding: 0px;
    }
    .food-body > div {
        align-items: flex-start;
    }
    .food-type {
        width: 35%;
    }
    .food-allergens {
        width: 35%;
    }
    .food-buy {
        width: 100%;
        justify-content: center;
        margin: 0 !important;
    }
    .food-buy p {
        width: 40%;
        height: 60px;
        font-size: 20px;
    }
    .food-buy button {
        width: 60%;
        height: 62px;
        font-size: 25px;
    }
}
</style>
