import QueryString from 'qs'
import Food from '~/assets/data/Food.class'

export default class FoodApi {
  constructor ($axios) {
    this.axios = $axios
  }

  findAllFood () {
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

  findFoodByRestaurant (id) {
    return this.axios({
      method: 'get',
      url: 'manage/food/restaurant',
      params: { restaurantId: id }
    }).then((response) => {
      const foods = []
      response.data.forEach((food) => {
        foods.push(new Food(food.food_ID, food.name, food.description, food.available, food.price, food.category, food.foodType, food.menus, food.allergens))
      })
      return foods
    })
  }

  findFoodByCategoryInMenu (menuId, categoryId) {
    return this.axios({
      method: 'get',
      url: 'manage/food/menu',
      params: { menuId, categoryId }
    }).then((response) => {
      const foods = []
      response.data.forEach((food) => {
        foods.push(new Food(food.food_ID, food.name, food.description, food.available, food.price, food.category, food.foodType, food.menus, food.allergens))
      })
      return foods
    })
  }

  filterFoods (foods, foodTypeIds, allergenIds) {
    return this.axios({
      method: 'put',
      url: 'manage/food/filter',
      params: { foodType: foodTypeIds, allergen: allergenIds },
      paramSerializer: (params) => {
        return QueryString.stringify(params, { arrayFormat: 'repeat' })
      },
      data: { foods }
    }).then((response) => {
      const foods = []
      response.data.forEach((food) => {
        foods.push(new Food(food.food_ID, food.name, food.description, food.available, food.price, food.category, food.foodType, food.menus, food.allergens))
      })
      return foods
    })
  }

  sortByPrice (foods, desc) {
    return this.axios({
      method: 'put',
      url: 'manage/food/sort',
      params: { by: 'price', desc },
      data: { foods }
    }).then((response) => {
      const foods = []
      response.data.forEach((food) => {
        foods.push(new Food(food.food_ID, food.name, food.description, food.available, food.price, food.category, food.foodType, food.menus, food.allergens))
      })
      return foods
    })
  }

  create (food, allergenIds, menuId, categoryId, foodTypeId) {
    return this.axios({
      method: 'post',
      url: 'manage/food/new',
      params: { allergenId: allergenIds, menuId, categoryId, foodTypeId },
      paramSerializer: (params) => {
        return QueryString.stringify(params, { arrayFormat: 'repeat' })
      },
      data: {
        food
      }
    }).then((response) => {
      return response.data
    })
  }

  activate (id) {
    return this.axios({
      method: 'put',
      url: 'manage/food/toggle',
      params: { foodId: id }
    }).then((response) => {
      return response.data
    })
  }

  delete (id) {
    return this.axios({
      method: 'delete',
      url: 'manage/food/delete',
      params: { foodId: id }
    })
  }
}
