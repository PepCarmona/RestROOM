import Food from '~/assets/data/Food.class'

export default class FoodApi {
  constructor ($axios) {
    this.axios = $axios
  }

  findAll () {
    return this.axios({
      method: 'get',
      url: 'food/all'
    }).then((response) => {
      const foods = []
      response.data.forEach((food) => {
        foods.push(new Food(food.food_ID, food.name, food.foodType.name, [], food.price))
      })
      return foods
    })
  }
}
