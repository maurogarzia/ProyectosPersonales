import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { IEmpresa } from "../../types/dtos/empresa/IEmpresa";

interface CompanyState {
    selectedCompany : IEmpresa | null;
}

const initialState: CompanyState = {
    selectedCompany: null,
}

const companySlice = createSlice({
    name: "company",
    initialState,
    reducers: {
            setSelectedCompany:(state, action: PayloadAction<IEmpresa>) => {
                state.selectedCompany = action.payload;
            },
            clearSelectedCompany: (state) => {
                state.selectedCompany = null
            },
            
        },
        
    }

)

export const {setSelectedCompany, clearSelectedCompany} = companySlice.actions

export default companySlice.reducer