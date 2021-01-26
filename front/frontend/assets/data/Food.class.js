export default class Food {
  constructor (id, name, description, type, allergens, price, available) {
    this.id = id
    this.name = name
    this.description = description
    this.type = type
    this.allergens = allergens
    this.price = price
    this.available = available
  }
}
