import { Product } from './product';

export class CartItem {

    constructor(public id?: string,
                public name?: string,
                public image_url?: string,
                public unit_price?: number,
                public quantity: number = 1) {

    }

}
