import { TcDetail } from './tc-detail';
import { TcClient } from './tc-client';

export class TcOrder {
    public orderId: number;
    public tcClient: TcClient;
    public tcDetail: TcDetail[];
}
