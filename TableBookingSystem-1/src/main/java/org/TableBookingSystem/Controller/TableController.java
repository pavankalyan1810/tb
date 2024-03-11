package org.TableBookingSystem.Controller;

import java.util.List;

import org.TableBookingSystem.Service.TableService;
import org.TableBookingSystem.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tables")
public class TableController {
	
	
	@Autowired
    private TableService tableService;
	
	@GetMapping
	public List<Table> getAllTables() {
		return tableService.getAllTables();
	}
	
	@GetMapping("/available")
	public List<Table> getAvailableTables() {
		return tableService.getAvailableTables();
	}
	
	@GetMapping("/{id}")
    public Table getTableById(@PathVariable Long tableId) {
        return tableService.getTableByTableId(tableId);
    }
	
	@PostMapping("/add")
    public String addTable(@RequestBody Table table ) {
        tableService.addTable(table);
        return "Table added successfully";
    }
	
	@PostMapping("/{id}/set-available")
    public ResponseEntity<?> setTableAsAvailable(@PathVariable Long tableId) {
        return new ResponseEntity<>(tableService.setTableAsAvailable(tableId),HttpStatus.OK);
    	
    }
}
