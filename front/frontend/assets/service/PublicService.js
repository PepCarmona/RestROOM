import QueryString from 'qs'
import Restaurant from '~/assets/data/public/Restaurant.class'
import Service from '~/assets/data/public/Service.class'

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
        restaurants.push(new Restaurant(restaurant.id, restaurant.name, restaurant.description, restaurant.address, restaurant.city, restaurant.country, restaurant.zip_code, '', '', restaurant.website, restaurant.phone, restaurant.email, restaurant.services))
      })
      return restaurants
    })
  }

  findRestaurantById (id) {
    return this.axios({
      method: 'get',
      url: 'public/restaurant/',
      params: { id }
    }).then((response) => {
      return response.data
    })
  }

  findAllServices () {
    return this.axios({
      method: 'get',
      url: 'public/service/all'
    }).then((response) => {
      const services = []
      response.data.forEach((service) => {
        services.push(new Service(service.id, service.name))
      })
      return services
    })
  }

  filterByService (restaurants, serviceIds) {
    return this.axios({
      method: 'put',
      url: 'public/restaurant',
      params: { serviceIds },
      paramSerializer: (params) => {
        return QueryString.stringify(params, { arrayFormat: 'repeat' })
      },
      data: { restaurants }
    }).then((response) => {
      const restaurants = []
      response.data.forEach((restaurant) => {
        restaurants.push(new Restaurant(restaurant.restaurant_ID, restaurant.name, restaurant.description, restaurant.address, restaurant.city, restaurant.country, restaurant.zip_code, '', '', restaurant.website, restaurant.phone, restaurant.email))
      })
      return restaurants
    })
  }
}
