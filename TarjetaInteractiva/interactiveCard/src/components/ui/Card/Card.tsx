import styles from './Card.module.css'
import image6 from '../../../images/image6.png'

export const Card = () => {
    // SitioWeb
    const web = 'https://www.youtube.com/watch?v=F-A_ujDnMo4'

    // Datos email
    const email = 'maurogarzia2@gmail.com'
    const subject = 'Consulta de Servicio'
    const body = 'Hola, estoy interesado en contratar servicios'
    const encodedSubject = encodeURIComponent(subject)
    const encodedBody = encodeURIComponent(body)

    // Datos numero
    const phonNumbre = '5492616928706'
    const message = 'Hola, estoy interesado en contratar servicios'
    const encodeMessage = encodeURIComponent(message)

    return (
        <div className={styles.containerCard}>
            <div className={styles.blackZone}>
                <img src={image6} alt="" />
            </div>    
            <div className={styles.yellowZone}>
                <div className={styles.titlePrincipal}>
                    <h2>S.A.N</h2>
                    <h4>Hidráulica</h4> 
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