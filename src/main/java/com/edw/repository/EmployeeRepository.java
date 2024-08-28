package com.edw.repository;

import com.edw.model.EmployeeModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * <pre>
 *  com.edw.repository.EmployeeRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Aug 2024 9:05
 */
@Transactional
@ApplicationScoped
public class EmployeeRepository implements PanacheRepositoryBase<EmployeeModel, Long> {

    public List<EmployeeModel> findFiveLatest() {
        return EmployeeModel.findAll(Sort.by("id", Sort.Direction.Descending))
                .page(Page.ofSize(5))
                .list();
    }
}
