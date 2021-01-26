export default class Food {
  constructor (id, name, description, available, price, category, type, menus, allergens) {
    this.id = id
    this.name = name
    this.description = description
    this.available = available
    this.price = price
    this.category = category
    this.type = type
    this.menus = menus
    this.allergens = allergens
  }
}
