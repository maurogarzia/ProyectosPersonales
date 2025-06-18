import { create } from "zustand";
import image from '../images/image6.png'
import { IDataCompany } from "./types/IDataCompany";


interface IUseStoreData{
    data: IDataCompany

    setData: (newData : IDataCompany) => void
}

export const useStoreData = create<IUseStoreData>((set) => ({
    data: {
        title: 'S.A.N',
        subtitle: 'Hidraulica',
        email: 'maurogarzia2@gmail.com',
        phoneNumber: 2616928706,
        webSite: 'https://www.draccohidraulica.com.ar/',
        logo: image
    },

    setData : (newData) => set({data : newData})
}))