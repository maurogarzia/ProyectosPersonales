
import { useState } from 'react'
import { Card, ICard } from '../ui/Card/Card'
import { CardReverse } from '../ui/CardReverse/CardReverse'
import styles from './Screen.module.css'
import { motion, AnimatePresence } from "framer-motion";
import { ModalData } from '../ui/ModalData/ModalData';

export const Screen = () => {

    const [viewCard, setViewCard] = useState(false) // Estado para mostrar los componentes
    const [viewModal, setViewModal] = useState(false)

    // Valores por defecto
    const [cardValues, setCardValues] = useState<ICard>({
        title : 'S.A.N',
        subTitle : 'Hidraulica',
        mail : 'maurogarzia2@gmial.com',
        phone : '2616928706',
        webSite : 'https://www.youtube.com/watch?v=Ne-9-7hpbRw&list=RDMMLf566pMNCOw&index=4',
    })
    
    return (
        <div className={styles.containerPrincipal}>
            <button className={styles.spinButton} onClick={() => setViewCard(!viewCard)}>
                <p>Girar</p>
            </button>
            <button className={styles.spinButton} onClick={() => setViewModal(true)}>
                Cambiar Datos
            </button>

            <div>
                <AnimatePresence mode='wait'>
                    {viewModal && 
                        <div>
                            <ModalData card={cardValues} closeModal={() => setViewModal(false)}/>
                        </div>
                    }
                    {viewCard ? (
                        <motion.div
                            key="reverse"
                            initial={{opacity:1 , rotateY: 90}}
                            animate={{opacity: 1, rotateY : 0}}
                            exit={{opacity:1, rotateY: -90}}
                            transition={{duration : 0.2}}
                            style={{perspective : '2000px'}}
                        >
                            <CardReverse/>
                        </motion.div>
                    ): (
                        <motion.div
                            key='front'
                            initial={{opacity : 1, rotateY: 90}}
                            animate ={{opacity : 1, rotateY : 0}}
                            exit={{opacity: 1 , rotateY : -90}}
                            transition={{duration : 0.2}}
                            style={{perspective : '2000px'}}
                        >
                            <Card 
                                title={cardValues.title}
                                subTitle={cardValues.subTitle}
                                mail={cardValues.mail}
                                webSite={cardValues.webSite}
                                phone={cardValues.phone}
                            />
                        </motion.div>
                    )}
                </AnimatePresence>
            </div>
            
        </div>
    )
}