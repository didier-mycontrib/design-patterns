Singleton : sur tp.dao.ProduitDaoFactory (dp-core-phase 1 à 2)
            puis sur tp.ioc.MyIocBeanFactory (dp-core-phase 3)
            
Facory method: sur  tp.dao.ProduitDaoFactory   (dp-core-phase 1 à 2)        
            
Stratégie : sur tp.dao.ProduitDaoJdbc         
            déléguant à tp.ds.MyParamDataSource (javax.sql.DataSource)
            
IOC/injection de dépendance : 
            sur tp.ioc.MyIocBeanFactory
            et sur dao,service,ioc.exemple de (dp-core-phase 3)
            tp.test.CoordinateurTest , ...
            
DAO (Data Access Object):
			sur tp.service.GestionProduitsImpl
			déléguant à tp.dao.ProduitDao (Jdbc, Simu ou Jpa)
			
Facade : sur tp.service.Facade et tp.service.MyFacadeImpl
         et tp.test.MyAppFacadeTest	
         
DTO (basic) : sur tp.dto.ProduitDto
              et sur tp.service.GestionProduits , GestionProduitsImpl                                 