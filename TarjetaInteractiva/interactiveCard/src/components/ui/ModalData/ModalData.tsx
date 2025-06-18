
import { useState } from 'react'
import styles from './ModalData.module.css'
import { IDataCompany } from '../../types/IDataCompany'
import { useStoreData } from '../../useStoreData'
import { useStoreModal } from '../../useStoreModal'



export const ModalData = () => {

    const {data, setData} = useStoreData()
    const {closeModal} = useStoreModal()

    const [formData, setFormData] = useState<IDataCompany>({
        title : 0 || data.title,
        subtitle : 0 || data.subtitle,
        email : 0 || data.email,
        phoneNumber : 0 || data.phoneNumber,
        webSite: 0 || data.webSite,
        logo : 0 || data.logo
    })
    
    // Manejo de inputs

    const handleChange = (e : React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target

        if (name === 'phoneNumber'){
            setFormData((prev) => ({
                ...prev,
                [name] : Number(value)
            }))
        }

        setFormData((prev) => ({
            ...prev,
            [name] : value
        }))
    }

    const handleSubmit = (e : React.FormEvent) => {
        e.preventDefault()

        try {
            setData(formData)
            closeModal()
            alert('Ser cambiaron los datos')
        } catch (error : any) {
            console.log(error.message);
            alert('No se pudieron cambiar los datos')
        }
    }

    return (
        <div className={styles.containerPrincipal}>
            <div className={styles.containerTitle}>
                <h3>Formulario de datos</h3>
            </div>
            <form action="" onSubmit={handleSubmit}>
                <div className={styles.containerData}>
                    <label htmlFor="">Title</label>
                    <input type="text" name='title' value={formData.title} id="" placeholder='title' onChange={handleChange}/>

                    <label htmlFor="">Subtitle</label>
                    <input type="text" name='subtitle' value={formData.subtitle} id="" placeholder='subtitle'  onChange={handleChange}/>

                    <label htmlFor="">Email</label>
                    <input type="email" name='email' value={formData.email} id="" placeholder='email' onChange={handleChange}/>

                    <label htmlFor="">Contact</label>
                    <input type="number" name='phoneNumber' value={formData.phoneNumber} id="" placeholder='contact' onChange={handleChange}/>

                    <label htmlFor="">Web Site</label>
                    <input type="text" name='webSite' value={formData.webSite} id="" placeholder='web site' onChange={handleChange}/>

                    <label htmlFor="">Logo</label>
                    <input type="text" name="logo" value={formData.logo} id="" placeholder='logo' onChange={handleChange}/> 

                </div>
                <div className={styles.containerButtons}>
                    <button type='button' onClick={closeModal}>Cancelar</button>
                    <button type='submit'>Confirmar</button>
                </div>
            </form>
            
        </div>
    )
}