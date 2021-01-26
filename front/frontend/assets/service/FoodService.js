import Food from '~/assets/data/Food.class'

export default class FoodApi {
  constructor ($axios) {
    this.axios = $axios
  }

  findAll () {
    return this.axios({
      method: 'get',
      url: 'manage/food/all'
    }).then((response) => {
      const foods = []
      response.data.forEach((food) => {
        foods.push(new Food(food.food_ID, food.name, food.description, food.available, food.price, food.category, food.foodType, food.menus, food.allergens))
      })
      return foods
    })
  }
}
