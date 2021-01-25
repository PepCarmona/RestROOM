import Restaurant from '~/assets/data/public/Restaurant.class'

export default class PublicApi {
  constructor ($axios) {
    this.axios = $axios
  }

  findAllRestaurants () {
    return this.axios({
      method: 'get',
      url: 'public/restaurant/all'
    }).then((response) => {
      const restaurants = []
      response.data.forEach((restaurant) => {
        restaurants.push(new Restaurant(restaurant.restaurant_ID, restaurant.name, restaurant.description, restaurant.address, restaurant.city, restaurant.country, restaurant.zip_code, '', '', restaurant.website, restaurant.phone, restaurant.email))
      })
      return restaurants
    })
  }

  findRestaurantById (id) {
    return this.axios({
      method: 'get',
      url: 'public/restaurant/' + id
    }).then((response) => {
      return response.data
    })
  }
}
