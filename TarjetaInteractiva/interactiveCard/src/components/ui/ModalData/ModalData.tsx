import React, { FC, useState } from 'react'
import styles from './ModalData.module.css'
import { ICard } from '../Card/Card'

interface IModal{
    closeModal : () => void,
    card : ICard,
}

export const ModalData:FC<IModal> = ({closeModal, card}) => {

    // Valores por defecto
    
    const [formValues, setFormValues] = useState<ICard>({
        title : card.title,
        subTitle : card.subTitle,
        mail : card.mail,
        phone : card.phone,
        webSite : card.webSite,
    })

    // Manejo de inputs
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target
        setFormValues({...formValues, [name] : value})
    }

    return (
        <div className={styles.containerPrincipal}>
            <div className={styles.containerTitle}>
                <h3>Formulario de datos</h3>
            </div>
            <form action="">
                <div className={styles.containerData}>
                    <label htmlFor="">Title</label>
                    <input type="text" name={formValues.title} id="" placeholder='title' onChange={handleChange}/>
                    <label htmlFor="">Subtitle</label>
                    <input type="text" name={formValues.subTitle} id="" placeholder='subtitle'  onChange={handleChange}/>
                    <label htmlFor="">Email</label>
                    <input type="email" name={formValues.mail} id="" placeholder='email' onChange={handleChange}/>
                    <label htmlFor="">Contact</label>
                    <input type="number" name={formValues.phone} id="" placeholder='contact' onChange={handleChange}/>
                    <label htmlFor="">Web Site</label>
                    <input type="text" name={formValues.webSite} id="" placeholder='web site' onChange={handleChange}/>
                    <label htmlFor="">Logo</label>
                    <input type="file" name="" id=""  placeholder='logo'/> 
                </div>
                <div className={styles.containerButtons}>
                    <button onClick={closeModal}>Cancelar</button>
                    <button type='submit'>Confirmar</button>
                </div>
            </form>
            
        </div>
    )
}