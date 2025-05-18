import styles from './Card.module.css'
import image6 from '../../../images/image6.png'
import { FC } from 'react'

export interface ICard{
    title : string,
    subTitle : string,
    mail: string,
    webSite: string,
    phone: string
}

export const Card : FC<ICard> = ({title, subTitle, mail, webSite, phone}) => {


    // SitioWeb
    const web = webSite

    // Datos email
    const email = mail
    const subject = 'Consulta de Servicio'
    const body = 'Hola, estoy interesado en contratar servicios'
    const encodedSubject = encodeURIComponent(subject)
    const encodedBody = encodeURIComponent(body)

    // Datos numero
    const phonNumbre = phone
    const message = 'Hola, estoy interesado en contratar servicios'
    const encodeMessage = encodeURIComponent(message)

    return (
        <div className={styles.containerCard}>
            <div className={styles.blackZone}>
                <img src={image6} alt="" />
            </div>    
            <div className={styles.yellowZone}>
                <div className={styles.titlePrincipal}>
                    <h2>{title}</h2>
                    <h4>{subTitle}</h4> 
                </div>
                <div className={styles.containerContact}>

                    <div className={styles.dates}>
                        <div className={styles.divIcon}>
                            <span className="material-symbols-outlined">
                                mail
                            </span>
                        </div>
                        <a href={`https://mail.google.com/mail/?view=cm&fs=1&to=${email}&su=${encodedSubject}&body=${encodedBody}`} 
                        target="_blank" 
                        rel="noopener noreferrer" 
                        className={styles.email}>
                            Email
                        </a>
                    </div>
                    <div className={styles.dates}>
                        <div className={styles.divIcon}>
                            <span className="material-symbols-outlined">
                                language
                            </span>
                        </div>
                        
                        <a href={web} >SitioWeb</a>
                    </div>
                    <div className={styles.dates}>
                        <div className={styles.divIcon}>
                            <span className="material-symbols-outlined">
                                call
                            </span>
                        </div>
                        <a href={`http://wa.me/${phonNumbre}?text=${encodeMessage}`}>
                            Contact
                        </a>
                    </div>
                </div>
            </div>
        </div>
    )
}