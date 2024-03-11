// AnnouncementCollocation.ts
import {HouseType} from "./HouseType";
import {EquipmentType} from "./EquipementType";


export class AnnouncementCollocation {

    annoncementCollocationId!: number;
    homeSize!: number;
    numPerso!: number;
    address!: string;
    imageHouse!: string;
    pricePerPerson!: number;
    houseType!: HouseType;
    equipmentType!: EquipmentType;

}
