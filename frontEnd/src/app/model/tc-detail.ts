import { TcProduct } from './tc-product';

export class TcDetail {
  public OrderID: number;
  public tcProduct: TcProduct;
  public cantidad: number;
  public costUnit: number;
  public priceUnit: number;
  public total: number;
}
