import { Button } from "react-bootstrap";
import style from "./ModalAddSucursal.module.css";
import { ChangeEvent, FC, useEffect, useState } from "react";
import { ICreateSucursal } from "../../../../types/dtos/sucursal/ICreateSucursal";
import Swal from "sweetalert2";
import { sucursalService } from "../../../../Services/sucursalService";
import { countryService } from "../../../../Services/countryServices";
import { IPais } from "../../../../types/IPais";
import { IProvincia } from "../../../../types/IProvincia";
import { ILocalidad } from "../../../../types/ILocalidad";
import { provinceService } from "../../../../Services/provinceService";
import { localityService } from "../../../../Services/localityServices";

interface IModalAdd {
    closeModalAdd: () => void; // Función que recibe desde CardCompany para cerrar el modal
    idEmpresa: number; // Recibe idEmpresa como prop para obtener los datos de la sucursal
}

const ModalAddSucursal: FC<IModalAdd> = ({ closeModalAdd, idEmpresa }) => {
    const [newSucursal, setNewSucursal] = useState<ICreateSucursal>({
        nombre: '',
        horarioApertura: '',
        horarioCierre: '',
        esCasaMatriz: false,
        latitud: 0,
        longitud: 0,
        domicilio: {
            calle: '',
            numero: 0,
            cp: 0,
            piso: 0,
            nroDpto: 0,
            idLocalidad: 0,
        },
        idEmpresa: idEmpresa,
        logo: null,
    });

    // Función que maneja el cambio de los inputs, incluyendo campos anidados
    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const { name, value, type, checked } = e.target;
    
        setNewSucursal((prev) => {
            if (name in prev.domicilio) {
                return {
                    ...prev,
                    domicilio: {
                        ...prev.domicilio,
                        [name]: type === 'number' ? parseInt(value) : value,
                    },
                };
            }
            return {
                ...prev,
                [name]: type === 'checkbox' ? checked : (type === 'number' ? parseFloat(value) : value),
            };
        });
    };
    

    // Función que maneja el envío de los campos del formulario a la API
    const handleSubmit = async (e: React.MouseEvent<HTMLButtonElement>) => {
        e.preventDefault();

        if (!newSucursal.nombre || !newSucursal.horarioApertura || !newSucursal.horarioCierre || newSucursal.latitud <= 0) {
            alert("Complete todos los campos");
            return;
        }

        try {
            console.log("Datos enviados:", newSucursal);
            await sucursalService.createSucursal(newSucursal);

            Swal.fire({
                icon: "success",
                title: "Sucursal agregada",
                showConfirmButton: false,
                timer: 1500,
                willClose: () => {
                    closeModalAdd();
                    window.location.reload();
                },
            });
        } catch (error) {
            console.error("El problema es: ", error);
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Algo salió mal!",
            });
        }

     

    };

       // Select de localidades
       const [countries, setCountries] = useState<IPais[]>([]);
       const [provinces, setProvinces] = useState<IProvincia[]>([]);
       const [localities, setLocalities] = useState<ILocalidad[]>([]);
       
       const [selectedCountry, setSelectedCountry] = useState("");
       const [selectedProvince, setSelectedProvince] = useState("");
       const [selectedLocality, setSelectedLocality] = useState("");
       
       // Cargar países al montar el componente
       useEffect(() => {
           const fetchCountries = async () => {
               try {
                const data = await countryService.getAllCountries(); // Cambiado a async/await
                setCountries(data);
               } catch (error) {
                   console.error("Error al cargar los países:", error);
               }
           };
           fetchCountries();
       }, []);
   
       // Cargar provincias cuando se selecciona un país
       useEffect(() => {
           if (selectedCountry) {
               const fetchProvinces = async () => {
                   try {
                       const data = await provinceService.getAllProvincesByCountryId(Number(selectedCountry));  
                       setProvinces(data);
                       setLocalities([]); // Reiniciar localidades al cambiar el país
                   } catch (error) {
                       console.error("Error al cargar las provincias:", error);
                   }
               };
               fetchProvinces();
           }
       }, [selectedCountry]);
   
       // Cargar localidades cuando se selecciona una provincia
       useEffect(() => {
           if (selectedProvince) {
               const fetchLocalities = async () => {
                   try {
                       const data = await localityService.getAllLocalitiesByProvinceId(Number(selectedProvince)); 
                       setLocalities(data); // Reiniciar localidades al cambiar el país
                   } catch (error) {
                       console.error("Error al cargar las localidades:", error);
                   }
               };
               fetchLocalities();
           }
       }, [selectedProvince]);
   
       const handleCountryChange = (e: ChangeEvent<HTMLSelectElement>) => {
           setSelectedCountry(e.target.value);
           setSelectedProvince("");
           setSelectedLocality("");
       };
   
       const handleProvinceChange = (e: ChangeEvent<HTMLSelectElement>) => {
           setSelectedProvince(e.target.value);
           setSelectedLocality("");
       };
   
       const handleLocalityChange = (e: ChangeEvent<HTMLSelectElement>) => {
        const localidadId = parseInt(e.target.value);
        setSelectedLocality(e.target.value);
    
        setNewSucursal((prev) => ({
            ...prev,
            domicilio: {
                ...prev.domicilio,
                idLocalidad: localidadId,
            },
        }));
    };
    return (
        <div className={style.containerPrincipal}>
            <div className={style.containerTitle}>
                <h2>Agregar Sucursal</h2>
            </div>

            <div>
                <form action="" className={style.containerForm}>

                    <div className={style.blockOne}>

                        <label htmlFor="nombre">Nombre</label>
                        <input type="text" placeholder="Nombre de la Sucursal" name="nombre" value={newSucursal.nombre} onChange={handleChange} />
                        
                        <label htmlFor="horarioApertura">Horario de apertura</label>
                        <input type="text" placeholder="Horario Apertura" name="horarioApertura" value={newSucursal.horarioApertura} onChange={handleChange} />
                        
                        <label htmlFor="horarioCierre">Horario de cierre</label>
                        <input type="text" placeholder="Horario Cierre" name="horarioCierre" value={newSucursal.horarioCierre} onChange={handleChange} />
                        
                        <label htmlFor="esCasaMatriz">Es Casa Matriz</label>
                        <input type="checkbox" name="esCasaMatriz" checked={newSucursal.esCasaMatriz} onChange={handleChange} />

                        <label htmlFor="latitud">Latitud</label>
                        <input type="number" placeholder="Latitud" name="latitud" value={newSucursal.latitud} onChange={handleChange} />

                        <label htmlFor="longitud">Longitud</label>
                        <input type="number" placeholder="Longitud" name="longitud" value={newSucursal.longitud} onChange={handleChange} />

                        <label htmlFor="calle">Calle</label>
                        <input type="text" placeholder="Calle de la sucursal" name="calle" value={newSucursal.domicilio.calle} onChange={handleChange} />
                        
                        <label htmlFor="numero">Número</label>
                        <input type="number" placeholder="Número de la calle" name="numero" value={newSucursal.domicilio.numero} onChange={handleChange} />

                    </div>
                    
                    <div className={style.blockTwo}>
                        <label htmlFor="cp">Código Postal</label>
                        <input type="number" placeholder="Código Postal" name="cp" value={newSucursal.domicilio.cp} onChange={handleChange} />

                        <label htmlFor="piso">Piso</label>
                        <input type="number" placeholder="Piso" name="piso" value={newSucursal.domicilio.piso} onChange={handleChange} />

                        <label htmlFor="nroDpto">Número de Departamento</label>
                        <input type="number" placeholder="Nro. Departamento" name="nroDpto" value={newSucursal.domicilio.nroDpto} onChange={handleChange} />

                        <label htmlFor="country">País</label>
                        <select id="country" value={selectedCountry} onChange={handleCountryChange}>
                            <option value="">Seleccione un país</option>
                            {countries.map((country) => (
                                <option key={country.id} value={country.id}>
                                    {country.nombre}
                                </option>
                            ))}
                        </select>

                        <label htmlFor="province">Provincia</label>
                        <select id="province" value={selectedProvince} onChange={handleProvinceChange} disabled={!selectedCountry}>
                            <option value="">Seleccione una provincia</option>
                            {provinces.map((province) => (
                                <option key={province.id} value={province.id}>
                                    {province.nombre}
                                </option>
                            ))}
                        </select>

                        <label htmlFor="locality">Localidad</label>
                        <select id="locality" value={selectedLocality} onChange={handleLocalityChange} disabled={!selectedProvince}>
                            <option value="">Seleccione una localidad</option>
                            {localities.map((locality) => (
                                <option key={locality.id} value={locality.id}>
                                    {locality.nombre}
                                </option>
                            ))}
                        </select>

                        <label htmlFor="logo">Imagen</label>
                        <input type="text" placeholder="Link de imagen" name="logo" value={newSucursal.logo || ""} onChange={handleChange} />

                    </div>
                </form>
                
                <div className={style.containerButtons}>
                    <Button onClick={handleSubmit}>Aceptar</Button>
                    <Button onClick={closeModalAdd}>Cancelar</Button>
                </div>
            </div>
        </div>
    );
};

export default ModalAddSucursal;
