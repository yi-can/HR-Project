package com.team1.mapper;

import com.team1.dto.response.WorkerListResponse;
import com.team1.rabbitmq.model.AuthWorkerModel;
import com.team1.repository.entity.Worker;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T16:21:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class IWorkerMapperImpl implements IWorkerMapper {

    @Override
    public Worker toAuthWorker(AuthWorkerModel authWorkerModel) {
        if ( authWorkerModel == null ) {
            return null;
        }

        Worker.WorkerBuilder<?, ?> worker = Worker.builder();

        worker.authId( authWorkerModel.getAuthId() );
        worker.companyId( authWorkerModel.getCompanyId() );
        worker.username( authWorkerModel.getUsername() );
        worker.email( authWorkerModel.getEmail() );
        worker.firstName( authWorkerModel.getFirstName() );
        worker.lastName( authWorkerModel.getLastName() );
        worker.phone( authWorkerModel.getPhone() );
        worker.address( authWorkerModel.getAddress() );

        return worker.build();
    }

    @Override
    public WorkerListResponse toWorkerList(Worker worker) {
        if ( worker == null ) {
            return null;
        }

        WorkerListResponse.WorkerListResponseBuilder workerListResponse = WorkerListResponse.builder();

        workerListResponse.username( worker.getUsername() );
        workerListResponse.email( worker.getEmail() );
        workerListResponse.firstName( worker.getFirstName() );
        workerListResponse.lastName( worker.getLastName() );
        workerListResponse.phone( worker.getPhone() );
        workerListResponse.address( worker.getAddress() );
        workerListResponse.salary( worker.getSalary() );

        return workerListResponse.build();
    }

    @Override
    public WorkerListResponse toWorkerListener(Worker worker) {
        if ( worker == null ) {
            return null;
        }

        WorkerListResponse.WorkerListResponseBuilder workerListResponse = WorkerListResponse.builder();

        workerListResponse.username( worker.getUsername() );
        workerListResponse.email( worker.getEmail() );
        workerListResponse.firstName( worker.getFirstName() );
        workerListResponse.lastName( worker.getLastName() );
        workerListResponse.phone( worker.getPhone() );
        workerListResponse.address( worker.getAddress() );
        workerListResponse.salary( worker.getSalary() );

        return workerListResponse.build();
    }
}
