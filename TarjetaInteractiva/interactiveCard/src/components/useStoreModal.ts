import { create } from "zustand";

interface IStoreModal {
    modal: boolean
    openModal: VoidFunction
    closeModal: VoidFunction
}

export const useStoreModal = create<IStoreModal>((set) => ({
    modal: false,

    openModal: () =>  set({modal : true}),
    closeModal: () => set({modal: false})
}))