import Menu from '~/assets/data/Menu.class'
import MenuCategory from '~/assets/data/MenuCategory.class'
import Allergen from '~/assets/data/Allergen.class'
import FoodType from '~/assets/data/FoodType.class'

export default class MenuApi {
  constructor ($axios) {
    this.axios = $axios
  }

  findAllMenus () {
    return this.axios({
      menthod: 'get',
      url: 'menu/all'
    }).then((response) => {
      const menus = []
      response.data.forEach((menu) => {
        menus.push(new Menu(menu.menu_ID, menu.name, menu.description, menu.date_start, menu.date_finish, menu.available))
      })
      return menus
    })
  }

  findActiveMenus () {
    return this.axios({
      menthod: 'get',
      url: 'menu/active'
    }).then((response) => {
      const menus = []
      response.data.forEach((menu) => {
        menus.push(new Menu(menu.menu_ID, menu.name, menu.description, menu.date_start, menu.date_finish, menu.available))
      })
      return menus
    })
  }

  findActiveMenusByRestaurant (id) {
    return this.axios({
      menthod: 'get',
      url: 'menu/active/restaurant/' + id
    }).then((response) => {
      const menus = []
      response.data.forEach((menu) => {
        menus.push(new Menu(menu.menu_ID, menu.name, menu.description, menu.date_start, menu.date_finish, menu.available))
      })
      return menus
    })
  }

  findAllCategories () {
    return this.axios({
      menthod: 'get',
      url: 'menu/category/all'
    }).then((response) => {
      const categories = []
      response.data.forEach((category) => {
        categories.push(new MenuCategory(category.id, category.name))
      })
      return categories
    })
  }

  findCategoryById (id) {
    return this.axios({
      menthod: 'get',
      url: 'menu/category/' + id
    }).then((response) => {
      return response.data
    })
  }

  findAllAllergens () {
    return this.axios({
      menthod: 'get',
      url: 'menu/allergen/all'
    }).then((response) => {
      const allergens = []
      response.data.forEach((allergen) => {
        allergens.push(new Allergen(allergen.allergen_ID, allergen.name))
      })
      return allergens
    })
  }

  findAllFoodTypes () {
    return this.axios({
      menthod: 'get',
      url: 'menu/foodType/all'
    }).then((response) => {
      const types = []
      response.data.forEach((type) => {
        types.push(new FoodType(type.food_type_ID, type.name))
      })
      return types
    })
  }
}
