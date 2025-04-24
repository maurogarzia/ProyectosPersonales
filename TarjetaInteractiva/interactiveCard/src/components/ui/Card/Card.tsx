import styles from './Card.module.css'
import image6 from '../../../images/image6.png'

export const Card = () => {

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
                        <div className={styles.a}>
                            <span className="material-symbols-outlined">
                                mail
                            </span>
                        </div>
                        <a href='' className={styles.email}>maurogarzia2@gmail.com</a>
                    </div>
                    <div className={styles.dates}>
                        <div className={styles.a}>
                            <span className="material-symbols-outlined">
                                language
                            </span>
                        </div>
                        
                        <a href='' >www.SitioWeb.com</a>
                    </div>
                    <div className={styles.dates}>
                        <div className={styles.a}>
                            <span className="material-symbols-outlined">
                                call
                            </span>
                        </div>
                        <a href={`http://wa.me/${phonNumbre}?text=${encodeMessage}`} >2616928706</a>
                    </div>
                </div>
            </div>
        </div>
    )
}