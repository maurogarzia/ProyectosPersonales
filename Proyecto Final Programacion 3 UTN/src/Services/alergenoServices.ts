import axios from "axios"
import { IAlergenos } from "../types/dtos/alergenos/IAlergenos";
import { ICreateAlergeno } from "../types/dtos/alergenos/ICreateAlergeno";
import { IUpdateAlergeno } from "../types/dtos/alergenos/IUpdateAlergeno";



const BASE_URL = `${import.meta.env.VITE_BASE_URL_API}/alergenos`



export const alergenoService = {
    async getAllAlergenos() : Promise<IAlergenos[]> {
        const response = await axios.get(BASE_URL)
        return response.data;
    },

    async getAlergenoById(alergenoId: number) : Promise<IAlergenos> {
        const response = await axios.get(`${BASE_URL}/${alergenoId}`)
        return response.data;
    },

    async createAlergeno(newAlergeno: ICreateAlergeno) : Promise<ICreateAlergeno> {
        const response = await axios.post(BASE_URL, newAlergeno)
        return response.data;
    },

    async updateAlergeno(alergenoId: number, alergenoActualizado: IAlergenos) : Promise<IUpdateAlergeno> {
        const response = await axios.put(`${BASE_URL}/${alergenoId}`, alergenoActualizado)
        return response.data;
    },

    async deleteAlergeno(alergenoId: number) : Promise<void>{
        const response = await axios.delete(`${BASE_URL}/${alergenoId}`)
        return response.data
    },

    //dudo sobre como hacer POST DeleteImgAlergeno
    async deleteImgAlergeno(id: number, publicId: string): Promise<void> {
        try {
            const url = `${BASE_URL}/?id=${id}&publicId=${publicId}`;
            const response = await axios.delete(url);
            console.log('Imagen eliminada con éxito:', response.data);
        } catch (error) {
            console.error('Error al eliminar la imagen:', error);
            throw error;
        }
    }
}